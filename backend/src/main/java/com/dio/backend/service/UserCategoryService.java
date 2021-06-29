package com.dio.backend.service;

import com.dio.backend.model.UserCategory;
import com.dio.backend.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    UserCategoryRepository userCategoryRepository;

    @Autowired
    public UserCategoryService(UserCategoryRepository userCategoryRepository){
        this.userCategoryRepository = userCategoryRepository;
    }

    public UserCategory save(UserCategory userCategory){
        return userCategoryRepository.save(userCategory);
    }

    public List<UserCategory> findAll() {
        return userCategoryRepository.findAll();
    }

    public Optional<UserCategory> findById(Long id) {
        return userCategoryRepository.findById(id);
    }

    public UserCategory update(UserCategory workday){
        return userCategoryRepository.save(workday);
    }

    public void deleteUserCategory(Long id) {
        userCategoryRepository.deleteById(id);
    }

}
