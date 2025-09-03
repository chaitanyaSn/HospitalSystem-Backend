package com.hospital_management.UserMS.DTO;

import com.hospital_management.UserMS.Entity.UserEntity;
import com.hospital_management.UserMS.Entity.UserRole;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private UserRole role;
    private Long profileId;

    public UserEntity toEntity() {
        UserEntity user = new UserEntity();
        user.setId(this.id);
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(this.role);
        user.setProfileId(this.profileId);
        return user;
    }
}
