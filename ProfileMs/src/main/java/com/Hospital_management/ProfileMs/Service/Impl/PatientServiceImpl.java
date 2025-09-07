package com.Hospital_management.ProfileMs.Service.Impl;

import com.Hospital_management.ProfileMs.Dto.PatientDto;
import com.Hospital_management.ProfileMs.Entity.Patient;
import com.Hospital_management.ProfileMs.Repository.PatientRepository;
import com.Hospital_management.ProfileMs.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Long addPatient(PatientDto patientDto) {
        if (patientRepository.findByEmail(patientDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        if (patientDto.getAadharNumber() != null &&
                patientRepository.findByAadharNumber(patientDto.getAadharNumber()).isPresent()) {
            throw new RuntimeException("Aadhar Number already exists");
        }

        return patientRepository.save(patientDto.toEntity()).getId();
    }


    @Override
    public PatientDto getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient not found")).toDto();
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto) {
        // Check if patient exists
        patientRepository.findById(patientDto.getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Save updated entity and convert back to DTO
        return patientRepository.save(patientDto.toEntity()).toDto();
    }


}
