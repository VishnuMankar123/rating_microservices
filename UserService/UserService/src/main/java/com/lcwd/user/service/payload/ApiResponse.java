package com.lcwd.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse {

    private String message;
    private HttpStatus status;
    private boolean success;
}
