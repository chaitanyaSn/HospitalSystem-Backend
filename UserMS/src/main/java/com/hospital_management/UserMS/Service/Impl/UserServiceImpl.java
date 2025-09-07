package com.hospital_management.UserMS.Service.Impl;

import com.hospital_management.UserMS.Client.ProfileClient;
import com.hospital_management.UserMS.DTO.UserDto;
import com.hospital_management.UserMS.Entity.UserEntity;
import com.hospital_management.UserMS.Entity.UserRole;
import com.hospital_management.UserMS.Repository.UserRepository;
import com.hospital_management.UserMS.Service.ApiService;
import com.hospital_management.UserMS.Service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfileClient profileClient;

    @Override
    public void registerUser(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("User with email " + userDto.getEmail() + " already exists");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Long profileId=null;
        if(userDto.getRole().equals(UserRole.DOCTOR)){
            profileId= profileClient.addDoctorProfile(userDto);

        } else if (userDto.getRole().equals(UserRole.PATIENT)){
            profileId= profileClient.addPatientProfile(userDto);
        }
        System.out.println(profileId);
        userDto.setProfileId(profileId);
        userRepository.save(userDto.toEntity());
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .toDto();
    }

    // ❌ Not needed if you use AuthenticationManager + MyUserDetailService
    @Override
    public UserDto loginUser(UserDto userDto) {
        UserEntity user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return user.toDto();
    }

    @Override
    public void updateUser(UserDto userDto) {
        // TODO: implement user update
    }

    @Override
    public UserDto getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email))
                .toDto();
    }
}
