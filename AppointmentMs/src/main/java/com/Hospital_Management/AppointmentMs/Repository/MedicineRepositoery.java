package com.Hospital_Management.AppointmentMs.Repository;

import com.Hospital_Management.AppointmentMs.Entity.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepositoery extends CrudRepository<Medicine,Long> {
    List<Medicine> findAllByPrescription_Id(Long prescriptionId);
}
