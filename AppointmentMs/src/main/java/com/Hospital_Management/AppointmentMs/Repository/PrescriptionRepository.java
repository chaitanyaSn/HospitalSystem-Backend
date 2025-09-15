package com.Hospital_Management.AppointmentMs.Repository;

import com.Hospital_Management.AppointmentMs.Entity.Medicine;
import com.Hospital_Management.AppointmentMs.Entity.Prescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends CrudRepository<Prescription,Long> {

    Optional<Prescription> findByAppointment_Id(Long appointmentId);
    List<Prescription> findAllByPatientId(Long patientId);
}
