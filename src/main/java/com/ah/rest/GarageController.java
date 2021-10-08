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

import com.ah.data.Garage;
import com.ah.service.GarageServiceDB;

@RestController
public class GarageController {
	private GarageServiceDB service;

	public GarageController(GarageServiceDB service) {
		super();
		this.service = service;
	}

	@GetMapping("/getGarage/{id}")
	public Garage getGarageById(@PathVariable Integer id) {
		return this.service.getGarageById(id);
	}

	@GetMapping("/getAllGarages")
	public List<Garage> getAllGarages() {
		return this.service.getAllGarages();
	}

	@PostMapping("/createGarage")
	public ResponseEntity<Garage> createGarage(@RequestBody Garage garage) {
		Garage body = this.service.createGarage(garage);
		return new ResponseEntity<Garage>(body, HttpStatus.CREATED);
	}

	@PutMapping("/updateGarage/{id}")
	public ResponseEntity<Garage> updateGarage(@RequestBody Garage garage, @PathVariable Integer id) {
		Garage body = this.service.updateGarage(garage, id);
		return new ResponseEntity<Garage>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeGarage/{id}")
	public ResponseEntity<?> deleteGarage(@PathVariable Integer id) {
		boolean deleted = this.service.deleteGarage(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}