package com.kosify.car_shop_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosify.car_shop_api.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID>{
}
