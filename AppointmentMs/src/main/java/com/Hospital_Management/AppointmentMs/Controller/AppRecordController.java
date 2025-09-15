package com.Hospital_Management.AppointmentMs.Controller;

import com.Hospital_Management.AppointmentMs.Dto.AppRecordDto;
import com.Hospital_Management.AppointmentMs.Service.AppRecordService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class AppRecordController {

    @Autowired
    private AppRecordService appRecordService;

    @PostMapping("/create")
    public ResponseEntity<Long> createAppRecord(@RequestBody AppRecordDto request) {
        try {
            Long recordId = appRecordService.createAppRecord(request);
            return new ResponseEntity<>(recordId, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); // 409 Conflict for duplicate record
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found for invalid appointment
        }
    }

    @PutMapping
    public ResponseEntity<Void> updateAppRecord(@RequestBody AppRecordDto request) {
        try {
            appRecordService.updateRecord(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found for invalid record or appointment
        }
    }

    @GetMapping("/appointment/{appointmentId}")
    public ResponseEntity<AppRecordDto> getAppRecordByAppointmentId(@PathVariable Long appointmentId) {
        try {
            AppRecordDto record = appRecordService.getAppRecordByAppointmentID(appointmentId);
            return new ResponseEntity<>(record, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<AppRecordDto> getAppRecordById(@PathVariable Long recordId) {
        try {
            AppRecordDto record = appRecordService.getRecordById(recordId);
            return new ResponseEntity<>(record, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }



}