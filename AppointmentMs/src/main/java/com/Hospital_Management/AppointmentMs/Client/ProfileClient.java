package com.Hospital_Management.AppointmentMs.Client;


import com.Hospital_Management.AppointmentMs.Dto.DoctorDto;
import com.Hospital_Management.AppointmentMs.Dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ProfileMs")
public interface ProfileClient {
    @GetMapping("/profile/doctor/exists/{id}")
    Boolean doctorExists(@PathVariable Long id);

    @GetMapping("/profile/patient/exists/{id}")
    Boolean patientExists(@PathVariable Long id);

    @GetMapping("/profile/patient/get/{id}")
    PatientDto getPatientById(@PathVariable Long id);

    @GetMapping("/profile/doctor/get/{id}")
    DoctorDto getDoctorById(@PathVariable Long id);
}
