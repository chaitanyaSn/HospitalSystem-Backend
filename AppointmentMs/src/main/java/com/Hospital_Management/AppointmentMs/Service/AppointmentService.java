package com.Hospital_Management.AppointmentMs.Service;

import com.Hospital_Management.AppointmentMs.Dto.AppointmentDetail;
import com.Hospital_Management.AppointmentMs.Dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    Long scheduleAppointment(AppointmentDto appointmentDto);
    void cancelAppointment(Long appointmentId);
    void completeAppointment(Long appointmentId);
    AppointmentDto getAppointmentDetails(Long appointmentId);
    AppointmentDetail getAppointmentsDetailsWithName(Long appointmentId);
    List<AppointmentDetail> getAllAppointmentByPatientIs(Long patientId);
}
