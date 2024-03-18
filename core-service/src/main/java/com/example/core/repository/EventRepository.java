package com.example.core.repository;

import com.example.core.events.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
}
