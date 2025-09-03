package com.Hospital_management.ProfileMs.Repository;

import com.Hospital_management.ProfileMs.Entity.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient,Long> {
    Optional<Patient> findByEmail(String email);
    Optional<Patient> findByAadharNumber(String aadharNumber);
}
