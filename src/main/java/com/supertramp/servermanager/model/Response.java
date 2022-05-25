package com.supertramp.servermanager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Response {
    LocalDateTime timestamp;
    int statusCode;
    HttpStatus status;
    String reason;
    String message;
    String developerMessage;
    Map<?, ?> data;
}
