package com.example.demo.service.impl;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getCurrentUser() {
        // TODO: Implement get current user logic
        return null;
    }

    @Override
    public User updateCurrentUser(User userDetails) {
        // TODO: Implement update current user logic
        return null;
    }

    @Override
    public List<Address> getUserAddresses(Long userId) {
        // TODO: Implement get user addresses logic
        return null;
    }

    @Override
    public Address addUserAddress(Long userId, Address address) {
        // TODO: Implement add user address logic
        return null;
    }

    @Override
    public Address updateAddress(Long addressId, Address addressDetails) {
        // TODO: Implement update address logic
        return null;
    }

    @Override
    public void deleteAddress(Long addressId) {
        // TODO: Implement delete address logic
    }
}