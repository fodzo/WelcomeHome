package com.mycompany.welcomehome.reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycompany.welcomehome.exception.DateRangeException;
import com.mycompany.welcomehome.property.Property;
import com.mycompany.welcomehome.property.PropertyRepository;
import com.mycompany.welcomehome.user.User;
import com.mycompany.welcomehome.user.UserRepository;

import jakarta.el.PropertyNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	private final UserRepository userRepository;
	private final PropertyRepository propertyRepository;
	
	public Reservation addReservation(Reservation reservation,String tenantUsernameOrEmail,long propertyId) {
		
		Optional<Property> propertyOptional = propertyRepository.findById(propertyId);
		reservation.setProperty(propertyOptional.orElseThrow(() -> new PropertyNotFoundException("Property not found: "+propertyId)));
		
		Optional<User> userOptional = userRepository.findByUsernameOrEmail(tenantUsernameOrEmail);
		reservation.setTenant(userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found: "+tenantUsernameOrEmail)));
		
		Optional<Reservation> reservationOptional = reservationRepository.findByDateRange(propertyId, reservation.getStartDate(), reservation.getEndDate());
		
		if(reservationOptional.isPresent())
			throw new DateRangeException("The property is already reserved for the specified date range.");
		
		reservation.setCreatedAt(LocalDate.now());

		return reservationRepository.save(reservation);
		
		
		
		
		
	}

	public List<Reservation> getReservations(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return reservationRepository.findByTenant(usernameOrEmail);
	}
	
	

}
