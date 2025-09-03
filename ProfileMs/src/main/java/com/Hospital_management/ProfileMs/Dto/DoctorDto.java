package com.Hospital_management.ProfileMs.Dto;

import com.Hospital_management.ProfileMs.Entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String licenseNumber;
    private String specialization;
    private String department;
    private Integer totalExperience;

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.setId(this.id);
        doctor.setName(this.name);
        doctor.setEmail(this.email);
        doctor.setPhone(this.phone);
        doctor.setAddress(this.address);
        doctor.setLicenseNumber(this.licenseNumber);
        doctor.setSpecialization(this.specialization);
        doctor.setDepartment(this.department);
        doctor.setTotalExperience(this.totalExperience);
        return doctor;
    }


}
