package com.dio.backend.repository;

import com.dio.backend.model.AnnualLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualLeaveRepository extends JpaRepository<AnnualLeave, Long> {
}
