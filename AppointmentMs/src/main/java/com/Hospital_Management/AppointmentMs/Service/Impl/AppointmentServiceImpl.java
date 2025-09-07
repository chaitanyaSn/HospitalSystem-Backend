package com.Hospital_Management.AppointmentMs.Service.Impl;

import com.Hospital_Management.AppointmentMs.Client.ProfileClient;
import com.Hospital_Management.AppointmentMs.Dto.*;
import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import com.Hospital_Management.AppointmentMs.Repository.AppointmentRepository;
import com.Hospital_Management.AppointmentMs.Service.ApiService;
import com.Hospital_Management.AppointmentMs.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ProfileClient profileClient;

    @Override
    public Long scheduleAppointment(AppointmentDto appointmentDto) {
        Boolean doctorExists = profileClient.doctorExists(appointmentDto.getDoctorId());
        if(!doctorExists || doctorExists == null) {
            throw new RuntimeException("Doctor not found");
        }
        Boolean patientExists = profileClient.patientExists(appointmentDto.getPatientId());
        if(!patientExists || patientExists == null) {
            throw new RuntimeException("Patient not found");
        }
        appointmentDto.setStatus(Status.SCHEDULED);
        return appointmentRepository.save(appointmentDto.toEntity()).getId();
    }

    @Transactional
    @Override
    public void cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        if(appointment.getStatus().equals(Status.CANCELED)) {
            throw new RuntimeException("appointment already canceled");
        }
        appointment.setStatus(Status.CANCELED);
        appointmentRepository.save(appointment);
    }

    @Transactional
    @Override
    public void completeAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(Status.COMPLETED);
        appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDto getAppointmentDetails(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"))
                .toDto();
    }

    @Override
    public AppointmentDetail getAppointmentsDetailsWithName(Long appointmentId) {
        AppointmentDto appointmentDto = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"))
                .toDto();
        DoctorDto doctorDto = profileClient.getDoctorById(appointmentDto.getDoctorId());
        PatientDto patientDto = profileClient.getPatientById(appointmentDto.getPatientId());
        return new AppointmentDetail(appointmentDto.getId()
                ,appointmentDto.getPatientId()
                ,patientDto.getName()
                , appointmentDto.getDoctorId()
                , doctorDto.getName()
                , appointmentDto.getAppointmentDate()
                , appointmentDto.getAppointmentTime()
                , appointmentDto.getStatus(),
                appointmentDto.getReason()
                ,appointmentDto.getNotes());
    }
}
