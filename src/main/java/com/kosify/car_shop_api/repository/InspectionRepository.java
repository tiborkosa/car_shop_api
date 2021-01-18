package com.kosify.car_shop_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosify.car_shop_api.entity.InspectionResult;

public interface InspectionRepository extends JpaRepository<InspectionResult, UUID>{

}
