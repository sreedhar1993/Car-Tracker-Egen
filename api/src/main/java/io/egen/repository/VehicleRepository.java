package io.egen.repository;

import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
public interface VehicleRepository {
    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    void delete(Vehicle vehicle);

    List<Vehicle> updateAndInsert(List<Vehicle> vehicleList);
}
