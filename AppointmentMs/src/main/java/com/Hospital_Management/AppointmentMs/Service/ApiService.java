package com.Hospital_Management.AppointmentMs.Service;

import com.Hospital_Management.AppointmentMs.Dto.DoctorDto;
import com.Hospital_Management.AppointmentMs.Dto.PatientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ApiService {

    private final WebClient.Builder webClient;

    public Mono<Boolean> doctorExists(Long id){
        return webClient.build()
                .get()
                .uri("http://localhost:8081/profile/doctor/exists/{id}", id)
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false);
    }
    public Mono<Boolean> patientExists(Long id){
        return webClient.build()
                .get()
                .uri("http://localhost:8081/profile/patient/exists/{id}", id)
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false);
    }

    public Mono<PatientDto> getPatientById(Long id){
        return webClient.build()
                .get()
                .uri("http://localhost:8081/profile/patient/get/{id}", id)
                .retrieve()
                .bodyToMono(PatientDto.class);
    }
    public Mono<DoctorDto> getDoctorById(Long id){
        return webClient.build()
                .get()
                .uri("http://localhost:8081/profile/doctor/get/{id}", id)
                .retrieve()
                .bodyToMono(DoctorDto.class);
    }



}
