package com.Hospital_management.ProfileMs.Service.Impl;

import com.Hospital_management.ProfileMs.Dto.DoctorDto;
import com.Hospital_management.ProfileMs.Repository.DocterRepository;
import com.Hospital_management.ProfileMs.Service.DocterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DocterServiceImpl implements DocterService {

    private final DocterRepository docterRepository;

    @Override
    public Long addDoctor(DoctorDto doctorDto) {
        if(docterRepository.findByEmail(doctorDto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        if(docterRepository.findByLicenseNumber(doctorDto.getLicenseNumber()).isPresent()){
            throw new RuntimeException("License Number already exists");
        }
        return docterRepository.save(doctorDto.toEntity()).getId();

    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        return docterRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor not found")).toDto();
    }
}
