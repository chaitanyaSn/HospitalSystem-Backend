package com.Hospital_Management.AppointmentMs.Dto;


import com.Hospital_Management.AppointmentMs.Entity.AppRecord;
import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import com.Hospital_Management.AppointmentMs.Utility.StringListConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppRecordDto {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
    private List<String> symptoms;
    private String diagnosis;
    private List<String> test;
    private String notes;
    private String referral;
    private LocalDate followUp;
    private LocalDateTime createdAt;

    public AppRecord toEntity(Appointment appointment) {
        AppRecord entity = new AppRecord();
        entity.setId(this.id);
        entity.setPatientId(this.patientId);
        entity.setDoctorId(this.doctorId);
        entity.setAppointment(appointment);
        entity.setSymptoms(StringListConverter.convertListToString(this.symptoms));
        entity.setDiagnosis(this.diagnosis);
        entity.setTest(StringListConverter.convertListToString(this.test));
        entity.setNotes(this.notes);
        entity.setReferral(this.referral);
        entity.setFollowUp(this.followUp);
        entity.setCreatedAt(this.createdAt);
        return entity;
    }
}
