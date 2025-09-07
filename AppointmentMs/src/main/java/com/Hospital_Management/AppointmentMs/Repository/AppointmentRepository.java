package com.Hospital_Management.AppointmentMs.Repository;

import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
}
