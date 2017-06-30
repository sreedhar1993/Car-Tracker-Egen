package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
public interface VehicleService {
    List<Vehicle> findAll();

    Vehicle findOne(String id);

    Vehicle create(Vehicle vehicle);

    Vehicle update(String id, Vehicle vehicle);

    void delete(String id);

    List<Vehicle> updateAndInsert(List<Vehicle> vehicleList);
}
