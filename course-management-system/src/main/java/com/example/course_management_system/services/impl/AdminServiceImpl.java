package com.example.course_management_system.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_management_system.models.Users;
import com.example.course_management_system.repositories.UsersRepository;
import com.example.course_management_system.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired 
    private UsersRepository userRepository;  

    @Override  
    public List<Users> getAllStudents() {  
        return userRepository.findByRole("student");  
    }

    @Override
    public Optional<Users> findUserById(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
    }  

    // @Override  
    // public void saveUser(User user) {  
    //     userRepository.save(user);  
    // }  

    // @Override  
    // public void deleteUser(Long id) {  
    //     userRepository.deleteById(id);  
    // }  

    // @Override  
    // public Optional<User> findUserById(Long id) {  
    //     return userRepository.findById(id);  
    // }  

    // @Override
    // public Optional<Users> findUserById(int id) {
    //     throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
    // }
}
