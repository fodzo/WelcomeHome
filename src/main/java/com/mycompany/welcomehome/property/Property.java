package com.mycompany.welcomehome.property;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.mycompany.welcomehome.location.Point;
import com.mycompany.welcomehome.medias.Media;
import com.mycompany.welcomehome.user.User;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@Embedded
    private Point location;
    
    
    private String address;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne
    private User owner;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<Media> mediaList;

    
}
