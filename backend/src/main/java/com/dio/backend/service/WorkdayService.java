package com.dio.backend.service;

import com.dio.backend.model.Workday;
import com.dio.backend.repository.WorkdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkdayService {

    WorkdayRepository workdayRepository;

    @Autowired
    public WorkdayService(WorkdayRepository workdayRepository){
        this.workdayRepository = workdayRepository;
    }

    public Workday save(Workday workday){
       return workdayRepository.save(workday);
    }

    public List<Workday> findAll() {
        return workdayRepository.findAll();
    }

    public Optional<Workday> findById(Long id) {
        return workdayRepository.findById(id);
    }

    public Workday update(Workday workday){
        return workdayRepository.save(workday);
    }

    public void deleteWorkday(Long id) {
        workdayRepository.deleteById(id);
    }

}
