package com.Hospital_Management.AppointmentMs.Dto;

import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import com.Hospital_Management.AppointmentMs.Entity.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long appointmentID;
    private LocalDateTime prescriptionDate;
    private String notes;
    List<MedicineDto> medicines;

    public Prescription toEntity(){
        return new Prescription(id,patientId,doctorId,new Appointment(appointmentID),prescriptionDate,notes);
    }
}
