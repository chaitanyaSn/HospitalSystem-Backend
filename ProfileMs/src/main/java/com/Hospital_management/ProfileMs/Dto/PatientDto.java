package com.Hospital_management.ProfileMs.Dto;


import com.Hospital_management.ProfileMs.Entity.BloodGroup;
import com.Hospital_management.ProfileMs.Entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime dob;
    private String phone;
    private String address;
    private String aadharNumber;
    private BloodGroup bloodGroup;
    private String allergies;
    private String chronicDiseses;

    public Patient toEntity() {
        Patient patient = new Patient();
        patient.setId(this.id);
        patient.setName(this.name);
        patient.setEmail(this.email);
        patient.setDob(this.dob);
        patient.setPhone(this.phone);
        patient.setAddress(this.address);
        patient.setAadharNumber(this.aadharNumber);
        patient.setBloodGroup(this.bloodGroup);
        patient.setAllergies(this.allergies);
        patient.setChronicDiseses(this.chronicDiseses);
        return patient;
    }


}
