package com.Hospital_management.ProfileMs.Entity;

import com.Hospital_management.ProfileMs.Dto.DoctorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private LocalDateTime dob;
    private String phone;
    private String address;
    @Column(unique = true)
    private String licenseNumber;
    private String specialization;
    private String Department;
    private Integer totalExperience;

    public DoctorDto toDto() {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(this.id);
        doctorDto.setName(this.name);
        doctorDto.setEmail(this.email);
        doctorDto.setPhone(this.phone);
        doctorDto.setAddress(this.address);
        doctorDto.setLicenseNumber(this.licenseNumber);
        doctorDto.setSpecialization(this.specialization);
        doctorDto.setDepartment(this.Department);
        doctorDto.setTotalExperience(this.totalExperience);
        return doctorDto;
    }
}
