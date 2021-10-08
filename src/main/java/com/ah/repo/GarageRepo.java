package com.ah.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ah.data.Garage;

public interface GarageRepo extends JpaRepository<Garage, Integer> {

}
