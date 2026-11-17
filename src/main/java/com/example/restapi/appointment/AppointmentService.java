package com.example.restapi.appointment;

import com.example.restapi.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> getAll() { return repository.findAll(); }

    public Appointment getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Appointment not found with id: " + id));
    }

    public Appointment create(AppointmentRequest request) {
        return repository.save(new Appointment(request.customerName(), request.serviceName(), request.scheduledAt()));
    }

    public Appointment update(Long id, AppointmentRequest request) {
        Appointment appointment = getById(id);
        appointment.setCustomerName(request.customerName());
        appointment.setServiceName(request.serviceName());
        appointment.setScheduledAt(request.scheduledAt());
        return repository.save(appointment);
    }

    public void delete(Long id) { repository.delete(getById(id)); }
}
