package com.hospital.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status = Status.CONFIRMED;

    private LocalDateTime bookedAt = LocalDateTime.now();

    public enum Status {
        CONFIRMED, CANCELLED, COMPLETED
    }
}