package com.Hospital_Management.NotificationMs.dto;

import com.Hospital_Management.NotificationMs.entity.Status;
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
    private LocalDateTime appointmentTime;
    private Status status;
    private String reason;
    private String notes;
}

