package com.mycompany.welcomehome.reservation;

import java.time.LocalDate;
import com.mycompany.welcomehome.property.Property;
import com.mycompany.welcomehome.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    private User tenant;
    
    @ManyToOne
    private Property property;
    
    @Column(columnDefinition = "DATE")
    @NotNull
    private LocalDate startDate;
    
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;
    
    @Column(columnDefinition = "DATE")
    private LocalDate createdAt;
    
   
}
