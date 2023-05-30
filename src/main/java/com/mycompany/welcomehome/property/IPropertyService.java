package com.mycompany.welcomehome.property;

import java.util.List;

public interface IPropertyService{
	Property addProperty(Property property, String userNameOrEmail);

	List<Property> getProperties(String userNameFromJwtToken);
}
