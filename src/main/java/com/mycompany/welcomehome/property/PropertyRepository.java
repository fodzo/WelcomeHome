package com.mycompany.welcomehome.property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends JpaRepository<Property,Long>{
	
@Query("SELECT p FROM Property p WHERE p.owner.username=:owner or p.owner.email=:owner")
Page<Property> findByOwner(@Param("owner")String userId,Pageable page);
}
