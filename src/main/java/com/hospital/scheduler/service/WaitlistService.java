package com.hospital.scheduler.service;

import com.hospital.scheduler.model.*;
import com.hospital.scheduler.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WaitlistService {

    @Autowired
    private WaitlistRepository waitlistRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private SlotRepository slotRepository;

    public void addToWaitlist(User patient, Slot slot) {
        Waitlist waitlist = new Waitlist();
        waitlist.setPatient(patient);
        waitlist.setSlot(slot);
        waitlistRepository.save(waitlist);
    }

    public void assignNextPatient(Slot slot) {
        List<Waitlist> waitlist = waitlistRepository.findBySlotIdOrderByAddedAtAsc(slot.getId());

        if (!waitlist.isEmpty()) {
            Waitlist next = waitlist.get(0);

            slot.setStatus(Slot.Status.BOOKED);
            slotRepository.save(slot);

            Appointment appointment = new Appointment();
            appointment.setPatient(next.getPatient());
            appointment.setSlot(slot);
            appointment.setStatus(Appointment.Status.CONFIRMED);
            appointmentRepository.save(appointment);

            waitlistRepository.delete(next);
        } else {
            slot.setStatus(Slot.Status.AVAILABLE);
            slotRepository.save(slot);
        }
    }
}