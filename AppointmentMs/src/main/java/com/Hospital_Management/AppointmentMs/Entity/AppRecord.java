package com.Hospital_Management.AppointmentMs.Entity;


import com.Hospital_Management.AppointmentMs.Dto.AppRecordDto;
import com.Hospital_Management.AppointmentMs.Utility.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long doctorId;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="appointment_id")
    private Appointment appointment;
    private String symptoms;
    private String diagnosis;
    private String test;
    private String notes;
    private String referral;
    private LocalDate followUp;
    private LocalDateTime createdAt;

    public AppRecordDto toDto() {
        AppRecordDto dto = new AppRecordDto();
        dto.setId(this.id);
        dto.setPatientId(this.patientId);
        dto.setDoctorId(this.doctorId);
        dto.setAppointmentId(this.appointment != null ? this.appointment.getId() : null);
        dto.setSymptoms(StringListConverter.convertStringToList(this.symptoms));
        dto.setDiagnosis(this.diagnosis);
        dto.setTest(StringListConverter.convertStringToList(this.test));
        dto.setNotes(this.notes);
        dto.setReferral(this.referral);
        dto.setFollowUp(this.followUp);
        dto.setCreatedAt(this.createdAt);
        return dto;
    }

}
