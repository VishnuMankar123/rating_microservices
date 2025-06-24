package com.lcwd.user.service.service;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
      // Generate a random UUID for the user ID
        String string = UUID.randomUUID().toString();
        // Set the generated UUID as the user ID
        user.setUserId(string);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public User updateUser(String userId, User user) {
       return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    // Update other fields as necessary
                    existingUser.setAbout(user.getAbout());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(
                        user -> userRepository.delete(user),
                        () -> { throw new ResourceNotFoundException("User not found with id: " + userId); }
                );
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
