package com.mycompany.welcomehome.reservation;

import java.time.LocalDate;
import com.mycompany.welcomehome.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDto {
	
    private long id;
    
    private User tenant;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private LocalDate createdAt;
}

