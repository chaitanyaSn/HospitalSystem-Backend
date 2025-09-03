package com.Hospital_management.ProfileMs.Service;

import com.Hospital_management.ProfileMs.Dto.DoctorDto;

public interface DocterService {
    public Long addDoctor(DoctorDto doctorDto);
    public DoctorDto getDoctorById(Long id);
}
