package com.Hospital_management.ProfileMs.Service;

import com.Hospital_management.ProfileMs.Dto.DoctorDropDown;
import com.Hospital_management.ProfileMs.Dto.DoctorDto;

import java.util.List;

public interface DocterService {
    public Long addDoctor(DoctorDto doctorDto);
    public DoctorDto getDoctorById(Long id);
    DoctorDto updateDoctor(DoctorDto doctorDto);
    boolean doctorExists(Long id);
    List<DoctorDropDown> getDoctorDropDown();
}
