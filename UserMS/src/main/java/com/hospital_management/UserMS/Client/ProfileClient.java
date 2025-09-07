package com.hospital_management.UserMS.Client;



import com.hospital_management.UserMS.DTO.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="ProfileMs")
public interface ProfileClient {

    @PostMapping("/profile/doctor")
    Long addDoctorProfile(@RequestBody  UserDto userDto);

    @PostMapping("/profile/patient")
    Long addPatientProfile(@RequestBody  UserDto userDto);
}
