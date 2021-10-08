package com.ah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ah.data.Garage;
import com.ah.repo.GarageRepo;

@Service
public class GarageServiceDB {

	private GarageRepo repo;

	public GarageServiceDB(GarageRepo repo) {
		super();
		this.repo = repo;

	}

	public Garage getGarageById(Integer id) {
		return this.repo.getById(id);
	}

	public List<Garage> getAllGarages() {
		return this.repo.findAll();
	}

	public Garage createGarage(Garage garage) {
		return this.repo.save(garage);
	}

	public Garage updateGarage(Garage garage, Integer id) {
		Optional<Garage> optionalGarage = this.repo.findById(id); // mocked
		Garage toUpdate = optionalGarage.get(); // not mocked

		toUpdate.setName(garage.getName());
		toUpdate.setAddress(garage.getAddress());

		return this.repo.save(toUpdate);
	}

	public boolean deleteGarage(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
