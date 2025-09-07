package com.Hospital_Management.AppointmentMs.Service;

import com.Hospital_Management.AppointmentMs.Dto.AppointmentDto;

public interface AppointmentService {
    Long scheduleAppointment(AppointmentDto appointmentDto);
    void cancelAppointment(Long appointmentId);
    void completeAppointment(Long appointmentId);
    AppointmentDto getAppointmentDetails(Long appointmentId);
}
