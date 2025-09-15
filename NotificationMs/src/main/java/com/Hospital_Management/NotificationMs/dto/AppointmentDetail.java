package com.Hospital_Management.NotificationMs.dto;

import com.Hospital_Management.NotificationMs.entity.Status;
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
    private String patientEmail;
    private String patientPhone;
    private Long doctorId;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private Status status;
    private String reason;
    private String notes;
}

