package com.Hospital_Management.AppointmentMs.Service.Impl;

import com.Hospital_Management.AppointmentMs.Dto.PrescriptionDto;
import com.Hospital_Management.AppointmentMs.Repository.PrescriptionRepository;
import com.Hospital_Management.AppointmentMs.Service.MedicineService;
import com.Hospital_Management.AppointmentMs.Service.PrescriptionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final MedicineService medicineService;

    @Override
    public Long savePrescription(PrescriptionDto request) {
        Long prescriptionId=prescriptionRepository.save(request.toEntity()).getId();
        request.getMedicines().forEach(medicine->medicine.setPrescriptionId(prescriptionId));
        medicineService.saveAllMedicine(request.getMedicines());
        return prescriptionId;
    }

    @Override
    public PrescriptionDto getPrescriptionByAppointmentId(Long appointmentId) {
        PrescriptionDto prescriptionDto=prescriptionRepository.findByAppointment_Id(appointmentId).orElseThrow(()->new RuntimeException("")).toDto();
        prescriptionDto.setMedicines(medicineService.getAllMedicineByPrescriptionId(prescriptionDto.getId()));
        return prescriptionDto;
    }

    @Override
    public PrescriptionDto getPrescriptionById(Long prescriptionId) {
        PrescriptionDto dto= prescriptionRepository.findById(prescriptionId).orElseThrow(() -> new RuntimeException("Prescription not found")).toDto();
        dto.setMedicines(medicineService.getAllMedicineByPrescriptionId(dto.getId()));
        return dto;
    }
}
