package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();

    }

    public Vehicle findOne(String id) { return entityManager.find(Vehicle.class, id);

    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;

    }

    public Vehicle update(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
         entityManager.remove(vehicle);

    }

    public List<Vehicle> updateAndInsert(List<Vehicle> vehicleList) {
        for(Vehicle vehicle: vehicleList){
            Vehicle vehicleExists=entityManager.find(Vehicle.class,vehicle.getVin());
            if(vehicleExists!=null)
                entityManager.merge(vehicle);
            else
                entityManager.persist(vehicle);
        }
        return null;
    }
}
