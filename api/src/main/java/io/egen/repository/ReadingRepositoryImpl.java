package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Tires;
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
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    EntityManager entityManager;


    public List<Readings> findAll() {
        TypedQuery<Readings> query = entityManager.createNamedQuery("Readings.findAll",
                Readings.class);
        return query.getResultList();

    }

    public Readings create(Readings readings) {
        Vehicle existsVehicle = entityManager.find(Vehicle.class, readings.getVin());
        if (existsVehicle != null) {
            Tires tires = readings.getTires();
            entityManager.persist(tires);
            entityManager.persist(readings);
        }

        return readings;
    }
}
