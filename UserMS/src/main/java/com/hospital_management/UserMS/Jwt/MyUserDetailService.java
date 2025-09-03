package com.hospital_management.UserMS.Jwt;

import com.hospital_management.UserMS.DTO.UserDto;
import com.hospital_management.UserMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto dto = userService.getUser(email);

        if (dto == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // ✅ Adjust constructor arguments to match your CustomsUserDetail class
        return new CustomsUserDetail(
                dto.getId(),
                dto.getEmail(),         // username
                dto.getEmail(),         // (check if this should really be email twice)
                dto.getPassword(),      // must be BCrypt encoded in DB
                dto.getName(),
                dto.getRole(),
                null
        );
    }
}
