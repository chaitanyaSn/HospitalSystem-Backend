package com.Hospital_Management.AppointmentMs.Repository;

import com.Hospital_Management.AppointmentMs.Entity.AppRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppRecordRepository extends CrudRepository<AppRecord,Long> {
    Optional<AppRecord> findByAppointment_Id(Long appointmentId);
}
