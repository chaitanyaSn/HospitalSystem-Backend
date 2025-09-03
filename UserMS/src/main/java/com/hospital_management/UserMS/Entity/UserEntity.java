package com.hospital_management.UserMS.Entity;


import com.hospital_management.UserMS.DTO.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column(name = "profileId")
    private Long profileId;

    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setName(this.name);
        userDto.setEmail(this.email);
        userDto.setPassword(this.password);
        userDto.setRole(this.role);
        userDto.setProfileId(this.profileId);
        return userDto;
    }
}
