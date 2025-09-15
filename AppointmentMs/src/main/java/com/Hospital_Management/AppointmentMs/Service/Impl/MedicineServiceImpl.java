package com.Hospital_Management.AppointmentMs.Service.Impl;

import com.Hospital_Management.AppointmentMs.Dto.MedicineDto;
import com.Hospital_Management.AppointmentMs.Entity.Medicine;
import com.Hospital_Management.AppointmentMs.Repository.MedicineRepositoery;
import com.Hospital_Management.AppointmentMs.Service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepositoery medicineRepositoery;


    @Override
    public Long saveMedicine(MedicineDto request) {
        return medicineRepositoery.save(request.toEntity()).getId();
    }

    @Override
    public List<MedicineDto> saveAllMedicine(List<MedicineDto> requestList) {
        return ((List<Medicine>) medicineRepositoery.saveAll(
                requestList.stream().map(MedicineDto::toEntity).toList()))
                .stream()
                .map(Medicine::toDto)
                .toList();
    }


    @Override
    public List<MedicineDto> getAllMedicineByPrescriptionId(Long precriptionId) {
        return ((List<Medicine>) medicineRepositoery.findAllByPrescription_Id(precriptionId)).stream()
                .map(Medicine::toDto).toList();
    }
}
