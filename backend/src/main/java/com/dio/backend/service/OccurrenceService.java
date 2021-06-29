package com.dio.backend.service;

import com.dio.backend.model.Occurrence;
import com.dio.backend.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    OccurrenceRepository occurrenceRepository;

    @Autowired
    public OccurrenceService(OccurrenceRepository occurrenceRepository){
        this.occurrenceRepository = occurrenceRepository;
    }

    public Occurrence save(Occurrence occurrence){
        return occurrenceRepository.save(occurrence);
    }

    public List<Occurrence> findAll() {
        return occurrenceRepository.findAll();
    }

    public Optional<Occurrence> findById(Long id) {
        return occurrenceRepository.findById(id);
    }

    public Occurrence update(Occurrence occurrence){
        return occurrenceRepository.save(occurrence);
    }

    public void deleteOccurrence(Long id) {
        occurrenceRepository.deleteById(id);
    }

}
