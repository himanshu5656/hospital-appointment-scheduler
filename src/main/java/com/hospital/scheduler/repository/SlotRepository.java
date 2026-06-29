package com.hospital.scheduler.repository;

import com.hospital.scheduler.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByDoctorIdAndStatus(Long doctorId, Slot.Status status);
}