package com.Hospital_management.ProfileMs.Repository;

import com.Hospital_management.ProfileMs.Dto.DoctorDropDown;
import com.Hospital_management.ProfileMs.Entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DocterRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByLicenseNumber(String licenseNumber);

    @Query("SELECT d.id AS id,d.name AS name FROM Doctor d")
    List<DoctorDropDown> findAllDoctorDropDown();
}
