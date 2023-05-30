package com.mycompany.welcomehome.reservation;

import java.util.List;
import org.springframework.data.domain.Page;


public interface IReservationMapper {
	
 Reservation toReservation(ReservationRequestDto reservationDto);
 
 ReservationResponseDto toReservationDto(Reservation reservation);
 
 List<ReservationResponseDto> toReservationDTOs(List<Reservation> reservations);
 
 Page<ReservationResponseDto> toReservationDTOs(Page<Reservation> reservations);
}
