package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Vector;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Vehicle vehicle = vehicleRepository.findOne(id);
        if(vehicle == null)
        {
            throw new ResourceNotFoundException("Vehicle with Id:"+id+"doesn't exist.");
        }
        return vehicle;
    }

    @org.springframework.transaction.annotation.Transactional
    public Vehicle create(Vehicle vehicle) {
        Vehicle vehicleExists = vehicleRepository.findOne(vehicle.getVin());
        if(vehicleExists != null)
            throw new BadRequestException("Vehicle with ID:"+vehicle.getVin()+"already exists.");
        return vehicleRepository.create(vehicle);
    }

    @org.springframework.transaction.annotation.Transactional
    public Vehicle update(String id, Vehicle vehicle) {
        Vehicle vehicleExists = vehicleRepository.findOne(id);
        if(vehicleExists==null)
            throw new ResourceNotFoundException("Vehicle with Id:"+id+"doesn't exist.");
        return vehicleRepository.update(vehicle);
    }

    @org.springframework.transaction.annotation.Transactional
    public void delete(String id) {
        Vehicle vehicleExists = vehicleRepository.findOne(id);
        if(vehicleExists==null)
            throw new ResourceNotFoundException("Vehicle with Id:"+id+"doesn't exist.");

        vehicleRepository.delete(vehicleExists);
    }

   @org.springframework.transaction.annotation.Transactional
    public List<Vehicle> updateAndInsert(List<Vehicle> vehicleList) {
        return vehicleRepository.updateAndInsert(vehicleList);
    }
}
