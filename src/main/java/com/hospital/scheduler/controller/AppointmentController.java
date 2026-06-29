package com.hospital.scheduler.controller;

import com.hospital.scheduler.model.*;
import com.hospital.scheduler.repository.UserRepository;
import com.hospital.scheduler.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/book")
    public Appointment bookAppointment(@RequestParam Long patientId,
                                       @RequestParam Long slotId,
                                       @RequestParam String reason) {
        User patient = userRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return appointmentService.bookAppointment(patient, slotId, reason);
    }

    @DeleteMapping("/cancel/{id}")
    public Appointment cancelAppointment(@PathVariable Long id) {
        return appointmentService.cancelAppointment(id);
    }

    @GetMapping("/my/{patientId}")
    public List<Appointment> getMyAppointments(@PathVariable Long patientId) {
        return appointmentService.getMyAppointments(patientId);
    }
}