package com.Hospital_management.ProfileMs.Service;

import com.Hospital_management.ProfileMs.Dto.PatientDto;

public interface PatientService {
    public Long addPatient(PatientDto patientDto);
    public PatientDto getPatientById(Long id);
}
