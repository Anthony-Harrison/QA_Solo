package com.ah.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ah.data.Vehicle;
import com.ah.repo.VehicleRepo;

@Primary
@Service
public class VehicleServiceDB {

	private VehicleRepo repo;

	public VehicleServiceDB(VehicleRepo repo) {
		super();
		this.repo = repo;

	}

	public List<Vehicle> getVehiclebyModel(String model) {
		return this.repo.findByModel(model);
	}

	public Vehicle getVehicleById(Integer id) {
		return this.repo.findById(id).get();
	}

	public List<Vehicle> getAllVehicles() {
		return this.repo.findAll();
	}

	public Vehicle createVehicle(Vehicle vehicle) {
		return this.repo.save(vehicle);
	}

	public Vehicle updateVehicle(Vehicle vehicle, Integer id) {
		Optional<Vehicle> optionalVehicle = this.repo.findById(id);
		Vehicle toUpdate = optionalVehicle.get();

		toUpdate.setModel(vehicle.getModel());
		toUpdate.setNoOfWheels(vehicle.getNoOfWheels());
		toUpdate.setWeight(vehicle.getWeight());

		return this.repo.save(toUpdate);
	}

	public boolean deleteVehicle(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
