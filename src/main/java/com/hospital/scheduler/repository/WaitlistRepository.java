package com.hospital.scheduler.repository;

import com.hospital.scheduler.model.Waitlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WaitlistRepository extends JpaRepository<Waitlist, Long> {
    List<Waitlist> findBySlotIdOrderByAddedAtAsc(Long slotId);
}