package com.hospital_management.UserMS.Utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    private String errorMessage;
    private long errorCode;
    private LocalDateTime timestamp;

}
