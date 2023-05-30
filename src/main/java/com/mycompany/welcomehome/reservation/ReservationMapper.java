package com.mycompany.welcomehome.reservation;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.PageImpl;

@Component
public class ReservationMapper implements IReservationMapper {

    @Override
    public Reservation toReservation(ReservationRequestDto reservationDto) {
        
        return Reservation.builder()
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .build();
    }

    @Override
    public ReservationResponseDto toReservationDto(Reservation reservation) {
       
        return ReservationResponseDto.builder()
                .id(reservation.getId())
                .tenant(reservation.getTenant())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .build();
    }

    @Override
    public List<ReservationResponseDto> toReservationDTOs(List<Reservation> reservations) {
        
        return reservations.stream()
                .map(this::toReservationDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ReservationResponseDto> toReservationDTOs(Page<Reservation> reservations) {
    	
    	List<ReservationResponseDto> reservationDTOs = toReservationDTOs(reservations.getContent());
        
        return new PageImpl<>(reservationDTOs, reservations.getPageable(), reservations.getTotalElements());
    }
}
