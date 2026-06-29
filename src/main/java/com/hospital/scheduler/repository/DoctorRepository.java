package com.hospital.scheduler.repository;

import com.hospital.scheduler.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialization(String specialization);
    
    @Query("SELECT d FROM Doctor d JOIN FETCH d.user")
    List<Doctor> findAllWithUser();
}