package com.Hospital_Management.AppointmentMs.Service;

import com.Hospital_Management.AppointmentMs.Dto.PrescriptionDto;

public interface PrescriptionService {

    Long savePrescription(PrescriptionDto request);
    PrescriptionDto getPrescriptionByAppointmentId(Long appointmentId);
    PrescriptionDto getPrescriptionById(Long prescriptionId);
}
