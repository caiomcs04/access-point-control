package com.dio.backend.service;

import com.dio.backend.model.AnnualLeave;
import com.dio.backend.repository.AnnualLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnualLeaveService {

    AnnualLeaveRepository annualLeaveRepository;

    @Autowired
    public AnnualLeaveService(AnnualLeaveRepository annualLeaveRepository){
        this.annualLeaveRepository = annualLeaveRepository;
    }

    public AnnualLeave save(AnnualLeave annualLeave){
        return annualLeaveRepository.save(annualLeave);
    }

    public List<AnnualLeave> findAll() {
        return annualLeaveRepository.findAll();
    }

    public Optional<AnnualLeave> findById(Long id) {
        return annualLeaveRepository.findById(id);
    }

    public AnnualLeave update(AnnualLeave annualLeave){
        return annualLeaveRepository.save(annualLeave);
    }

    public void deleteAnnualLeave(Long id) {
        annualLeaveRepository.deleteById(id);
    }

}
