package com.Hospital_Management.AppointmentMs.Controller;


import com.Hospital_Management.AppointmentMs.Dto.AppointmentDetail;
import com.Hospital_Management.AppointmentMs.Dto.AppointmentDto;
import com.Hospital_Management.AppointmentMs.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class Appointmentcontroller {

    private final AppointmentService appointmentService;


    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentDetails(@PathVariable Long appointmentId) {
        AppointmentDto appointmentDto = appointmentService.getAppointmentDetails(appointmentId);
        return ResponseEntity.ok(appointmentDto);
    }
    @PostMapping("/schedule")
    public ResponseEntity<Long> scheduleAppointment(@RequestBody AppointmentDto appointmentDto) {
        Long appointmentId = appointmentService.scheduleAppointment(appointmentDto);

        return ResponseEntity.ok(appointmentId);
    }
    @PutMapping("/cancel/{appointmentId}")
    public ResponseEntity<String> cancelAppointment(@PathVariable  Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return new ResponseEntity<>("Appointment canceled successfully",HttpStatus.OK);
    }

    @PutMapping("/complete/{appointmentId}")
    public ResponseEntity<String> completeAppointment(@PathVariable  Long appointmentId) {
        appointmentService.completeAppointment(appointmentId);
        return new ResponseEntity<>("Appointment completed",HttpStatus.OK);

    }
    @GetMapping("/details/{appointmentId}")
    public ResponseEntity<AppointmentDetail> getAppointmentsDetailsWithName(@PathVariable Long appointmentId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsDetailsWithName(appointmentId));
    }

    @GetMapping("/getAllByPatient/{patientId}")
    public ResponseEntity<List<AppointmentDetail>> getAppointmentByPatient(@PathVariable Long patientId){
        return new ResponseEntity<>(appointmentService.getAllAppointmentByPatientIs(patientId),HttpStatus.OK);
    }

    @GetMapping("/getAllByDoctor/{doctorId}")
    public ResponseEntity<List<AppointmentDetail>> getAppointmentByDoctor(@PathVariable Long doctorId){
        return new ResponseEntity<>(appointmentService.getAllAppointmentByDoctorId(doctorId),HttpStatus.OK);
    }
}
