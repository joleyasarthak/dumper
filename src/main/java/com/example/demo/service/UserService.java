package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User getCurrentUser();
    User updateCurrentUser(User userDetails);
    List<Address> getUserAddresses(Long userId);
    Address addUserAddress(Long userId, Address address);
    Address updateAddress(Long addressId, Address addressDetails);
    void deleteAddress(Long addressId);
}