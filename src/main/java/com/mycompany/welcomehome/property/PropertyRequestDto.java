package com.mycompany.welcomehome.property;

import com.mycompany.welcomehome.location.Point;
import lombok.Data;

@Data

public class PropertyRequestDto {
	
private String address;
    
private String description;
    
private Point location;
    
}
