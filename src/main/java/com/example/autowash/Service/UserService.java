package com.example.autowash.Service;

import com.example.autowash.ApiResponse.ApiException;
import com.example.autowash.Model.User;
import com.example.autowash.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user) {
        User oldUser = userRepository.findUserById(id);
        if(oldUser != null) {
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            oldUser.setRole(user.getRole());
            userRepository.save(oldUser);
        }else throw new ApiException("cannot update user, user not found");
    }
    public void deleteUser(Integer id) {
        User oldUser = userRepository.findUserById(id);
        if(oldUser != null) {
            userRepository.delete(oldUser);
        }else throw new ApiException("cannot delete user, user not found");
    }

}