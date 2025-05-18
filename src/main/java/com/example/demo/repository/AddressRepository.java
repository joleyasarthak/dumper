package com.example.demo.repository;

import com.example.demo.model.Address;
import com.example.demo.model.enums.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByUserEmailAndAddressType(String email, AddressType addressType);
}