package com.ah.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ah.data.Vehicle;
import com.ah.service.VehicleServiceDB;

@RestController
public class VehicleController {
	private VehicleServiceDB service;

	public VehicleController(VehicleServiceDB service) {
		super();
		this.service = service;
	}

	@GetMapping("/getVehicleByModel/{model}")
	public List<Vehicle> getVehiclebyModel(@PathVariable String model) {
		return this.service.getVehiclebyModel(model);
	}

	@GetMapping("/getVehicle/{id}")
	public Vehicle getVehicleById(@PathVariable Integer id) {
		return this.service.getVehicleById(id);
	}

	@GetMapping("/getAllVehicles")
	public List<Vehicle> getAllVehicles() {
		return this.service.getAllVehicles();
	}

	@PostMapping("/createVehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
		Vehicle body = this.service.createVehicle(vehicle);
		return new ResponseEntity<Vehicle>(body, HttpStatus.CREATED);
	}

	@PutMapping("/updateVehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer id) {
		Vehicle body = this.service.updateVehicle(vehicle, id);
		return new ResponseEntity<Vehicle>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteVehicle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable Integer id) {
		boolean deleted = this.service.deleteVehicle(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
