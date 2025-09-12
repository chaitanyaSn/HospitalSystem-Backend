package com.Hospital_Management.NotificationMs.Client;



import com.Hospital_Management.NotificationMs.dto.DoctorDto;
import com.Hospital_Management.NotificationMs.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ProfileMs")
public interface ProfileClient {


    @GetMapping("/profile/patient/get/{id}")
    PatientDto getPatientById(@PathVariable Long id);

    @GetMapping("/profile/doctor/get/{id}")
    DoctorDto getDoctorById(@PathVariable Long id);
}
