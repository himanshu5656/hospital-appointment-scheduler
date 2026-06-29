package com.hospital.scheduler.service;

import com.hospital.scheduler.model.*;
import com.hospital.scheduler.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private WaitlistService waitlistService;

    public Appointment bookAppointment(User patient, Long slotId, String reason) {
        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        if (slot.getStatus() == Slot.Status.BOOKED) {
            throw new RuntimeException("Slot already booked");
        }

        slot.setStatus(Slot.Status.BOOKED);
        slotRepository.save(slot);

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setSlot(slot);
        appointment.setReason(reason);
        appointment.setStatus(Appointment.Status.CONFIRMED);

        return appointmentRepository.save(appointment);
    }

    public Appointment cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(Appointment.Status.CANCELLED);
        appointmentRepository.save(appointment);

        waitlistService.assignNextPatient(appointment.getSlot());

        return appointment;
    }

    public List<Appointment> getMyAppointments(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}