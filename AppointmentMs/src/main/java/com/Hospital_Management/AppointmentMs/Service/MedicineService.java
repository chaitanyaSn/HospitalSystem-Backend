package com.Hospital_Management.AppointmentMs.Service;

import com.Hospital_Management.AppointmentMs.Dto.MedicineDto;

import java.util.List;

public interface MedicineService {
    Long saveMedicine (MedicineDto request);
    List<MedicineDto> saveAllMedicine(List<MedicineDto> requestList);
    List<MedicineDto> getAllMedicineByPrescriptionId(Long precriptionId);

}
