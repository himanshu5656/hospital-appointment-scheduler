package com.hospital.scheduler.controller;

import com.hospital.scheduler.model.Doctor;
import com.hospital.scheduler.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAllWithUser();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @GetMapping("/specialization/{spec}")
    public List<Doctor> getBySpecialization(@PathVariable String spec) {
        return doctorRepository.findBySpecialization(spec);
    }
}