package com.mycompany.welcomehome.reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.mycompany.welcomehome.property.Property;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{

	@Query(value = "SELECT * FROM reservation r " +
            "WHERE r.property_id = :propertyId AND (:startDate BETWEEN r.startDate AND r.endDate " +
            "OR :endDate BETWEEN r.startDate AND r.endDate) LIMIT 1", nativeQuery = true)
    Optional<Reservation> findByDateRange(@Param("propertyId") long propertyId,@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
   
	@Query("SELECT r from Reservation r WHERE r.tenant.username = :key OR r.tenant.email = :key ORDER BY r.createdAt DESC")
	List<Reservation> findByTenant(@Param("key") String usernameOrEmail);
	




}
