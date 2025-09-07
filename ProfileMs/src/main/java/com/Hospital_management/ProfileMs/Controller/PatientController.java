package com.Hospital_management.ProfileMs.Controller;


import com.Hospital_management.ProfileMs.Dto.PatientDto;
import com.Hospital_management.ProfileMs.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Long> addPatient(@RequestBody PatientDto patientDto){
        return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDto> updatePatient( @RequestBody PatientDto patientDto) {
        PatientDto updatedPatient = patientService.updatePatient(patientDto);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> patientExists(@PathVariable Long id) {
        boolean exists = patientService.patientExists(id);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}
