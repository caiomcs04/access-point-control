package com.dio.backend.repository;

import com.dio.backend.model.DateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateType, Long> {
}
