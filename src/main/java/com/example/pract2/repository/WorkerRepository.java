package com.example.pract2.repository;

import com.example.pract2.model.workerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<workerModel, Long> {
}
