package com.Hospital_Management.AppointmentMs.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDetail {
    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private String appointmentDate;
    private LocalDateTime appointmentTime;
    private Status status;
    private String reason;
    private String notes;
}
