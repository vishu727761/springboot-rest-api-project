package com.example.restapi.appointment;

import com.example.restapi.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Appointment>>> getAll() {
        return ResponseEntity.ok(ApiResponse.success("Appointments fetched successfully", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Appointment>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Appointment fetched successfully", service.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Appointment>> create(@Valid @RequestBody AppointmentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Appointment created successfully", service.create(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Appointment>> update(@PathVariable Long id,
                                                            @Valid @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Appointment updated successfully", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Appointment deleted successfully", null));
    }
}
