package com.hospital.scheduler.controller;

import com.hospital.scheduler.model.Slot;
import com.hospital.scheduler.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotRepository slotRepository;

    @GetMapping("/doctor/{doctorId}")
    public List<Slot> getAvailableSlots(@PathVariable Long doctorId) {
        return slotRepository.findByDoctorIdAndStatus(doctorId, Slot.Status.AVAILABLE);
    }
}