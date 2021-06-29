package com.dio.backend.service;

import com.dio.backend.model.DateType;
import com.dio.backend.repository.DateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DateTypeService {

    DateTypeRepository dateTypeRepository;

    @Autowired
    public DateTypeService(DateTypeRepository dateTypeRepository){
        this.dateTypeRepository = dateTypeRepository;
    }

    public DateType save(DateType dateType){
        return dateTypeRepository.save(dateType);
    }

    public List<DateType> findAll() {
        return dateTypeRepository.findAll();
    }

    public Optional<DateType> findById(Long id) {
        return dateTypeRepository.findById(id);
    }

    public DateType update(DateType dateType){
        return dateTypeRepository.save(dateType);
    }

    public void deleteDateType(Long id) {
        dateTypeRepository.deleteById(id);
    }

}
