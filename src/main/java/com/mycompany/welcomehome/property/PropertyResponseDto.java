package com.mycompany.welcomehome.property;



import com.mycompany.welcomehome.location.Point;
import com.mycompany.welcomehome.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropertyResponseDto {
	
    private long id;
    
    private Point location;
    
    
    private String address;
    
    
    private String description;
    
    
    private User owner;
    
}
