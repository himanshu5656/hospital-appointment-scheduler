package com.hospital.scheduler.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDate slotDate;
    private LocalTime slotTime;

    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;

    public enum Status {
        AVAILABLE, BOOKED
    }
}