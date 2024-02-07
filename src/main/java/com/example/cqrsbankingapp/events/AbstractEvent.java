package com.example.cqrsbankingapp.events;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "events")
@Entity
@Getter
@Setter
public abstract class AbstractEvent implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID aggregateId;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private LocalDateTime timestamp;

    @JdbcTypeCode(SqlTypes.JSON)
    private Object payload;

}
