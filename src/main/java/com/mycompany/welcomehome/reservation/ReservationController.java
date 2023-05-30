package com.mycompany.welcomehome.reservation;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.welcomehome.security.jwt.JwtUtils;
import com.mycompany.welcomehome.shared.UriUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Context;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController("/api/reservations/")
public class ReservationController {
	
private final IReservationMapper reservationMapper;

private final ReservationService reservationService;

private final JwtUtils jwtUtils;

@PostMapping
@ApplyReservationAspect
ResponseEntity<?> addReservation(@Valid ReservationRequestDto reservation,@PathVariable(value="propertyId",required=true) long propertyId,@Context HttpServletRequest request) {

String usernameOrEmail = jwtUtils.getUserNameFromJwtToken(request);
Reservation newReservation=reservationService.addReservation(reservationMapper.toReservation(reservation), usernameOrEmail, propertyId);
URI location=UriUtil.buildUriWithId("/", newReservation.getId());
return ResponseEntity.created(location).body("Reservation added sucessfully!");

}

@GetMapping
public ResponseEntity<?> tenantReservations(@Context HttpServletRequest request) {

String usernameOrEmail = jwtUtils.getUserNameFromJwtToken(request);

return ResponseEntity.ok(reservationMapper.toReservationDTOs(reservationService.getReservations(usernameOrEmail)));
	
}
}
