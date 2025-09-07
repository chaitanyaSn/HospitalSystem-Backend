package com.hospital_management.UserMS.Jwt;

import com.hospital_management.UserMS.Entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomsUserDetail implements UserDetails {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String name;
    private UserRole role;
    private Long profileId;
    private Collection<? extends GrantedAuthority> authorities;
}
