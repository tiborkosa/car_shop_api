package com.kosify.car_shop_api.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosify.car_shop_api.entity.InspectionResult;
import com.kosify.car_shop_api.exception.ResourceNotFoundException;
import com.kosify.car_shop_api.repository.InspectionRepository;

@RestController
@RequestMapping("/api/v1/")
public class InspectionController {

	@Autowired
	InspectionRepository inspectionRepository;
	
	@GetMapping("inspection/{id}")
	public ResponseEntity<InspectionResult> getUserById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
		InspectionResult inspection = inspectionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inspection not found with "+ id)); 
		return ResponseEntity.ok().body(inspection);
	}

	@GetMapping("inspection")
	public List<InspectionResult> getAllInspections(){
		return inspectionRepository.findAll();
	}
	
	@PutMapping("inspection")
	public InspectionResult updateInspection(@Validated @RequestBody InspectionResult inspection) throws ResourceNotFoundException {
		if(null == inspection.getId()) {
			throw new ResourceNotFoundException("Cannot update inspection without an id!");
		}
		return inspectionRepository.save(inspection);
	}
	
	@DeleteMapping("inspection/{id}")
	public String deleteInspection(@PathVariable(value="id") UUID id) throws ResourceNotFoundException {
		Optional<InspectionResult> inspection = inspectionRepository.findById(id);
		
		if(inspection.isPresent()) {
			inspectionRepository.delete(inspection.get());
			return "Inspection was deleted!";
		} else throw new ResourceNotFoundException("Could not locate inspection!");
	}
	
	@PostMapping("inspection")
	public InspectionResult postInspection(@Validated @RequestBody InspectionResult inspection) {
		return inspectionRepository.save(inspection);
	}
}
