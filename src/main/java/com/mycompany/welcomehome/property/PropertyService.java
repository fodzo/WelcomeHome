package com.mycompany.welcomehome.property;


import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.mycompany.welcomehome.user.User;
import com.mycompany.welcomehome.user.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyService implements IPropertyService{
    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;
    

    public Property addProperty(Property property, String userNameOrEmail) {
    	
    	Optional<User> userOptional = userRepository.findByUsernameOrEmail(userNameOrEmail);

        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found."));

        property.setOwner(user);
        return propertyRepository.save(property);


    }


	@Override
	public List<Property> getProperties(String userNameFromJwtToken) {
		// TODO Auto-generated method stub
		return propertyRepository.findByOwner(userNameFromJwtToken, PageRequest.of(0, 10)).getContent();
	}
}
