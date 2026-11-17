package com.example.restapi.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import java.time.LocalDateTime;

public record AppointmentRequest(
        @NotBlank(message = "Customer name is required")
        String customerName,

        @NotBlank(message = "Service name is required")
        String serviceName,

        @NotNull(message = "Appointment date and time are required")
        @Future(message = "Appointment must be in the future")
        LocalDateTime scheduledAt
) {}
