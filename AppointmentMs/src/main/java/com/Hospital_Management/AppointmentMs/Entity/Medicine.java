package com.Hospital_Management.AppointmentMs.Entity;


import com.Hospital_Management.AppointmentMs.Dto.MedicineDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long MedicineId;
    private String dosage;
    private String frequency;
    private Integer duration;
    private String instruction;
    private String type;
    private String route;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prescription_id")
    private Prescription prescription;


    public MedicineDto toDto() {
        return new MedicineDto(
                id,
                name,
                MedicineId,
                dosage,
                frequency,
                duration,
                instruction,
                type,
                route,
                prescription != null ? prescription.getId() : null  // Handle lazy loading and null cases
        );
    }


}
