package com.hospital_management.UserMS.Service;

import com.hospital_management.UserMS.DTO.UserDto;

public interface UserService {
    public void registerUser(UserDto userDto);
    public UserDto getUserById(Long id);
    public UserDto loginUser(UserDto userDto);
    public void updateUser(UserDto userDto);
    UserDto getUser(String email);
}
