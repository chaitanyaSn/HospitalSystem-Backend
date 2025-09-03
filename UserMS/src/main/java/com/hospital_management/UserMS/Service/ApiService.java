package com.hospital_management.UserMS.Service;

import com.hospital_management.UserMS.Config.WebClientConfig;
import com.hospital_management.UserMS.DTO.UserDto;
import com.hospital_management.UserMS.Entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ApiService {

    private final WebClient.Builder webClient;

    public Mono<Long> addProfile(UserDto userDto){
        if(userDto.getRole().equals(UserRole.DOCTOR)){
            return webClient.build().post().uri("http://localhost:8081/profile/doctor")
                    .bodyValue(userDto).retrieve().bodyToMono(Long.class);
        } else if (userDto.getRole().equals(UserRole.PATIENT)){
            return webClient.build().post().uri("http://localhost:8081/profile/patient")
                    .bodyValue(userDto).retrieve().bodyToMono(Long.class);
        }else{
            return Mono.empty();
            
        }
    }
}
