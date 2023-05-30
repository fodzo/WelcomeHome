package com.mycompany.welcomehome.reservation;


import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

public class ReservationConfig {
	@Bean
public IReservationMapper reservationMapper()
{
	return Mappers.getMapper(IReservationMapper.class);
}
}
