package com.mycompany.welcomehome.property;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;


@Component
public class PropertyMapper implements IPropertyMapper{

    @Override
	public Property toProperty(PropertyRequestDto dto) {
		// TODO Auto-generated method stub
		return Property.builder()
				.address(dto.getAddress())
				.description(dto.getDescription())
				.location(dto.getLocation()).build();
	}

	@Override
	public PropertyResponseDto toPropertyResponseDto(Property property) {
		// TODO Auto-generated method stub
		return PropertyResponseDto.builder()
				.address(property.getAddress())
				.description(property.getDescription())
				.id(property.getId())
				.location(property.getLocation())
				.build();
	}

	@Override
	public List<PropertyResponseDto> toPropertyResponseDTOs(List<Property> properties) {
		
		return properties.stream().map(this::toPropertyResponseDto).toList();
	}

	@Override
	public Page<PropertyResponseDto> toPropertyResponseDTOs(Page<Property> properties) {
		
		return new PageImpl<PropertyResponseDto>(toPropertyResponseDTOs(properties.getContent()), properties.getPageable(),properties.getTotalElements());
	}

}
