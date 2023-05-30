package com.mycompany.welcomehome.reservation;

import java.time.LocalDate;

import com.mycompany.welcomehome.annotation.DateRange;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DateRange(startDate = "startDate", endDate = "endDate")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReservationRequestDto {
	
    @NotNull(message="start date is required")
    private LocalDate startDate;
    
    @NotNull(message="end date is required")
    private LocalDate endDate;
    
}
