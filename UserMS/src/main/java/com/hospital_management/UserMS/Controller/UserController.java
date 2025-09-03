package com.hospital_management.UserMS.Controller;


import com.hospital_management.UserMS.DTO.LoginDto;
import com.hospital_management.UserMS.DTO.ResponseDto;
import com.hospital_management.UserMS.DTO.UserDto;
import com.hospital_management.UserMS.Exception.HmsException;
import com.hospital_management.UserMS.Jwt.JwtUtil;
import com.hospital_management.UserMS.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> registerUser(@RequestBody UserDto userDto){
        userService.registerUser(userDto);
        return ResponseEntity.ok(new ResponseDto("User registered successfully"));

    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) throws HmsException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
        }catch (AuthenticationException e){
            throw new HmsException("Invalid email or password");

        }
        final UserDetails userDetails= userDetailsService.loadUserByUsername(loginDto.getEmail());
        final String token= jwtUtil.generateToken(userDetails);
        return new ResponseEntity<>(token, HttpStatus.OK);

    }
    @GetMapping("/test")
    public String test(){
        return "User MS is working";
    }
}
