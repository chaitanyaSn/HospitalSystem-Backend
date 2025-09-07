package com.Hospital_Management.AppointmentMs.Entity;


import com.Hospital_Management.AppointmentMs.Dto.AppointmentDto;
import com.Hospital_Management.AppointmentMs.Dto.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String appointmentDate;
    private LocalDateTime appointmentTime;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String reason;
    private String notes;

    public AppointmentDto toDto() {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(this.id);
        appointmentDto.setPatientId(this.patientId);
        appointmentDto.setDoctorId(this.doctorId);
        appointmentDto.setAppointmentDate(this.appointmentDate);
        appointmentDto.setAppointmentTime(this.appointmentTime);
        appointmentDto.setStatus(this.status);
        appointmentDto.setReason(this.reason);
        appointmentDto.setNotes(this.notes);
        return appointmentDto;
    }
}
