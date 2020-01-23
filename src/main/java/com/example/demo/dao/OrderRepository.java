package com.example.demo.dao;

import com.example.demo.domain.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Oder, Long> {
    List<Oder> findByCreatedAtBetween(LocalDateTime startTime, LocalDateTime endDataTime);
}
