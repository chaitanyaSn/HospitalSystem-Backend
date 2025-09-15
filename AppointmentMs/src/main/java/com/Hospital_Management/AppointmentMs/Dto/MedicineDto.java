package com.Hospital_Management.AppointmentMs.Dto;

import com.Hospital_Management.AppointmentMs.Entity.Medicine; // Import your entity class
import com.Hospital_Management.AppointmentMs.Entity.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineDto {

    private Long id;
    private String name;
    private Long medicineId;
    private String dosage;
    private String frequency;
    private Integer duration;
    private String instruction;
    private String type;
    private String route;
    private Long prescriptionId;

    // Convert DTO to entity
    public Medicine toEntity() {
        return new Medicine(
                id,
                name,
                medicineId,
                dosage,
                frequency,
                duration,
                route,
                type,
                instruction,
                new Prescription(prescriptionId) // Assuming Prescription has a constructor with id
        );
    }

}
