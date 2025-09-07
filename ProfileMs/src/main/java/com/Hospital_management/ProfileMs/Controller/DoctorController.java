package com.Hospital_management.ProfileMs.Controller;


import com.Hospital_management.ProfileMs.Dto.DoctorDto;
import com.Hospital_management.ProfileMs.Service.DocterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile/doctor")
public class DoctorController {

    private final DocterService doctorService;

    @PostMapping
    public ResponseEntity<Long> addDoctor(@RequestBody DoctorDto doctorDto){
        Long id = doctorService.addDoctor(doctorDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id){
        DoctorDto doctorDto = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctorDto);
    }
    @PutMapping("/update")
    public ResponseEntity<DoctorDto> updateDoctor( @RequestBody DoctorDto doctorDto) {
        DoctorDto updatedDoctor = doctorService.updateDoctor(doctorDto);
        return ResponseEntity.ok(updatedDoctor);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> doctorExists(@PathVariable Long id) {
        boolean exists = doctorService.doctorExists(id);
        return ResponseEntity.ok(exists);
    }
}
