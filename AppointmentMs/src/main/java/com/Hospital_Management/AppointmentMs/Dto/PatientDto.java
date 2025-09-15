package com.Hospital_Management.AppointmentMs.Dto;


import com.Hospital_Management.AppointmentMs.Dto.BloodGroup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String phone;
    private String address;
    private String aadharNumber;
    private BloodGroup bloodGroup;
    private String allergies;
    private String chronicDiseses;
}
