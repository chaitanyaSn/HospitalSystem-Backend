package com.Hospital_Management.AppointmentMs.Service.Impl;

import com.Hospital_Management.AppointmentMs.Dto.AppRecordDto;
import com.Hospital_Management.AppointmentMs.Entity.AppRecord;
import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import com.Hospital_Management.AppointmentMs.Repository.AppRecordRepository;
import com.Hospital_Management.AppointmentMs.Repository.AppointmentRepository;
import com.Hospital_Management.AppointmentMs.Service.AppRecordService;
import com.Hospital_Management.AppointmentMs.Utility.StringListConverter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppRecordServiceImpl implements AppRecordService {

    private final AppRecordRepository appRecordRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    public Long createAppRecord(AppRecordDto request) {
        // Check if an AppRecord already exists for the given appointmentId
        Optional<AppRecord> existingRecord = appRecordRepository.findByAppointment_Id(request.getAppointmentId());
        if (existingRecord.isPresent()) {
            throw new IllegalStateException("An appointment record already exists for appointment ID: " + request.getAppointmentId());
        }

        // Fetch the Appointment entity
        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + request.getAppointmentId()));

        // Convert DTO to entity and save
        AppRecord entity = request.toEntity(appointment);
        return appRecordRepository.save(entity).getId();
    }

    @Override
    public void updateRecord(AppRecordDto request) {
        // Fetch the existing AppRecord
        AppRecord entity = appRecordRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("AppRecord not found with ID: " + request.getId()));

        // Fetch the Appointment entity
        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with ID: " + request.getAppointmentId()));

        // Update fields

        entity.setAppointment(appointment);
        entity.setSymptoms(StringListConverter.convertListToString(request.getSymptoms()));
        entity.setDiagnosis(request.getDiagnosis());
        entity.setTest(StringListConverter.convertListToString(request.getTest()));
        entity.setNotes(request.getNotes());
        entity.setReferral(request.getReferral());
        entity.setFollowUp(request.getFollowUp());
        // Save the updated entity
        appRecordRepository.save(entity);
    }

    @Override
    public AppRecordDto getAppRecordByAppointmentID(Long appointmentId) {
        // Fetch AppRecord by appointment ID
        AppRecord entity = appRecordRepository.findByAppointment_Id(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("AppRecord not found for appointment ID: " + appointmentId));
        return entity.toDto();
    }

    @Override
    public AppRecordDto getRecordById(Long recordId) {
        // Fetch AppRecord by record ID
        AppRecord entity = appRecordRepository.findById(recordId)
                .orElseThrow(() -> new EntityNotFoundException("AppRecord not found with ID: " + recordId));
        return entity.toDto();
    }
}