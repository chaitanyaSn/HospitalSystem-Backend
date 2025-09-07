package com.Hospital_Management.AppointmentMs.Dto;

import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String appointmentDate;
    private LocalDateTime appointmentTime;
    private Status status;
    private String reason;

    public Appointment toEntity() {
        Appointment appointment = new Appointment();
        appointment.setId(this.id);
        appointment.setPatientId(this.patientId);
        appointment.setDoctorId(this.doctorId);
        appointment.setAppointmentDate(this.appointmentDate);
        appointment.setAppointmentTime(this.appointmentTime);
        appointment.setStatus(this.status);
        appointment.setReason(this.reason);
        return appointment;
    }
}
