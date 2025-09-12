package com.Hospital_management.ProfileMs.Service.Impl;

import com.Hospital_management.ProfileMs.Dto.DoctorDropDown;
import com.Hospital_management.ProfileMs.Dto.DoctorDto;
import com.Hospital_management.ProfileMs.Repository.DocterRepository;
import com.Hospital_management.ProfileMs.Service.DocterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DocterServiceImpl implements DocterService {

    private final DocterRepository docterRepository;

    @Override
    public Long addDoctor(DoctorDto doctorDto) {
        if (docterRepository.findByEmail(doctorDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        if (doctorDto.getLicenseNumber() != null &&
                docterRepository.findByLicenseNumber(doctorDto.getLicenseNumber()).isPresent()) {
            throw new RuntimeException("License Number already exists");
        }

        return docterRepository.save(doctorDto.toEntity()).getId();
    }


    @Override
    public DoctorDto getDoctorById(Long id) {
        return docterRepository.findById(id).orElseThrow(()->new RuntimeException("Doctor not found")).toDto();
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto) {
        docterRepository.findById(doctorDto.getId())
                .orElseThrow(() -> new RuntimeException("doctorDto not found"));

        // Save updated entity and convert back to DTO
        return docterRepository.save(doctorDto.toEntity()).toDto();
    }

    @Override
    public boolean doctorExists(Long id) {
        return docterRepository.existsById(id);
    }

    @Override
    public List<DoctorDropDown> getDoctorDropDown() {
      return docterRepository.findAllDoctorDropDown();
    }
}
