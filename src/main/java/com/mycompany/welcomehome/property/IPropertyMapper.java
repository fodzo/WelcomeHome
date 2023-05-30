package com.mycompany.welcomehome.property;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IPropertyMapper {

public Property toProperty(PropertyRequestDto dto);

public PropertyResponseDto toPropertyResponseDto(Property property);

public List<PropertyResponseDto> toPropertyResponseDTOs(List<Property> properties);

public Page<PropertyResponseDto> toPropertyResponseDTOs(Page<Property> property);

}
