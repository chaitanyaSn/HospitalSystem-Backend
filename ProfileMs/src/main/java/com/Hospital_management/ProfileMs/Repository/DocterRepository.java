package com.Hospital_management.ProfileMs.Repository;

import com.Hospital_management.ProfileMs.Entity.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DocterRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByLicenseNumber(String licenseNumber);
}
