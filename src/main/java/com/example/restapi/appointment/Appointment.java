package com.example.restapi.appointment;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String serviceName;
    private LocalDateTime scheduledAt;

    public Appointment() {}

    public Appointment(String customerName, String serviceName, LocalDateTime scheduledAt) {
        this.customerName = customerName;
        this.serviceName = serviceName;
        this.scheduledAt = scheduledAt;
    }

    public Long getId() { return id; }
    public String getCustomerName() { return customerName; }
    public String getServiceName() { return serviceName; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setScheduledAt(LocalDateTime scheduledAt) { this.scheduledAt = scheduledAt; }
}
