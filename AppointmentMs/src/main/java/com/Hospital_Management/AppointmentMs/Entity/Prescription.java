package com.Hospital_Management.AppointmentMs.Entity;

import com.Hospital_Management.AppointmentMs.Dto.PrescriptionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long doctorId;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="appointment_id")
    private Appointment appointment;
    private LocalDateTime prescriptionDate;
    private String notes;

    public Prescription(Long id){
        this.id=id;
    }

    public PrescriptionDto toDto(){
        return new PrescriptionDto(id,patientId,doctorId,appointment.getId(),prescriptionDate,notes,null);
    }

}
