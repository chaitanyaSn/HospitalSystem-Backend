package com.Hospital_management.ProfileMs.Entity;

import com.Hospital_management.ProfileMs.Dto.PatientDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

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
    private String aadharNumber;
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    public PatientDto toDto() {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(this.id);
        patientDto.setName(this.name);
        patientDto.setEmail(this.email);
        patientDto.setDob(this.dob);
        patientDto.setPhone(this.phone);
        patientDto.setAddress(this.address);
        patientDto.setAadharNumber(this.aadharNumber);
        patientDto.setBloodGroup(this.bloodGroup);
        return patientDto;
    }


}
