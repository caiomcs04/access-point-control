package com.dio.backend.service;

import com.dio.backend.model.Operation;
import com.dio.backend.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {

    OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }

    public Operation save(Operation operation){
        return operationRepository.save(operation);
    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Optional<Operation> findById(Long id) {
        return operationRepository.findById(id);
    }

    public Operation update(Operation operation){
        return operationRepository.save(operation);
    }

    public void deleteOperation(Long id) {
        operationRepository.deleteById(id);
    }

}
