package com.ah.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ah.data.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByModel(String model);

}
