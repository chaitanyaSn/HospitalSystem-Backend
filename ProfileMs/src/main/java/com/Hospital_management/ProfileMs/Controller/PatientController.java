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
    public ResponseEntity<PatientDto> getPatientById(@RequestParam Long id){
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }
}
