package com.ah.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private int noOfWheels;
	private int weight;

	@ManyToOne
	private int garageId;

	public Vehicle(Integer id, String type, int noOfWheels, int weight) {
		super();
		this.id = id;
		this.type = type;
		this.noOfWheels = noOfWheels;
		this.weight = weight;
	}

	public Vehicle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getGarageId() {
		return garageId;
	}

	public void setGarageId(int garageId) {
		this.garageId = garageId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(garageId, id, noOfWheels, type, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return garageId == other.garageId && Objects.equals(id, other.id) && noOfWheels == other.noOfWheels
				&& Objects.equals(type, other.type) && weight == other.weight;
	}

}
