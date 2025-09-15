package com.Hospital_Management.AppointmentMs.Repository;

import com.Hospital_Management.AppointmentMs.Dto.AppointmentDetail;
import com.Hospital_Management.AppointmentMs.Entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {

    @Query("SELECT new com.Hospital_Management.AppointmentMs.Dto.AppointmentDetail(" +
            "a.id, a.patientId, '','','', a.doctorId, '', a.appointmentTime, a.status, a.reason, a.notes) " +
            "FROM Appointment a WHERE a.patientId = ?1")
    List<AppointmentDetail> findAllByPatientId(Long patientId);

    @Query("SELECT new com.Hospital_Management.AppointmentMs.Dto.AppointmentDetail(" +
            "a.id, a.patientId, '','','', a.doctorId, '', a.appointmentTime, a.status, a.reason, a.notes) " +
            "FROM Appointment a WHERE a.doctorId = ?1")
    List<AppointmentDetail> findAllByDoctorId(Long doctorId);
}
