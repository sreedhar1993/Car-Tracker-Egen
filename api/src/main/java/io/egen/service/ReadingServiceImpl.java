package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicle;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository readingRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public List<Readings> findAll() {
        return readingRepository.findAll();
    }

    @Transactional
    public Readings create(Readings readings) {
        return readingRepository.create(readings);
    }

    public List<Alert> checkForAlerts(Readings readings) {
        List<Alert> alerts = new ArrayList<Alert>();
            Vehicle vehicle = vehicleRepository.findOne(readings.getVin());
            if (vehicle != null) {
                if (readings.getEngineRpm() > vehicle.getRedlineRpm()) {
                    Alert alert = new Alert();
                    alert.setAlert("Engine RMP has crossed Red line RPM.");
                    alert.setPriority(Alert.Priority.HIGH);
                    alerts.add(alert);
                }
                if (readings.getFuelVolume() < vehicle.getMaxFuelVolume() * 0.1) {
                    Alert alert = new Alert();
                    alert.setAlert("Low on fuel");
                    alert.setPriority(Alert.Priority.MEDIUM);
                    alerts.add(alert);
                }
                if (checkTirePressure(readings.getTires().getFrontLeft())) {
                    Alert alert = new Alert();
                    alert.setAlert("Check pressure on Front Left tire");
                    alert.setPriority(Alert.Priority.LOW);
                    alerts.add(alert);
                }

                if (checkTirePressure(readings.getTires().getFrontRight())) {
                    Alert alert = new Alert();
                    alert.setAlert("Check pressure on Front Right tire");
                    alert.setPriority(Alert.Priority.LOW);
                    alerts.add(alert);
                }

                if (checkTirePressure(readings.getTires().getRearLeft())) {
                    Alert alert = new Alert();
                    alert.setAlert("Check pressure on Rear Left tire");
                    alert.setPriority(Alert.Priority.LOW);
                    alerts.add(alert);
                }

                if (checkTirePressure(readings.getTires().getRearRight())) {
                    Alert alert = new Alert();
                    alert.setAlert("Check pressure on Rear Right tire");
                    alert.setPriority(Alert.Priority.LOW);
                    alerts.add(alert);
                }

                if (readings.isCheckEngineLightOn() || readings.isEngineCoolantLow()) {
                    Alert alert = new Alert();
                    alert.setAlert("Engine needs maintainance");
                    alert.setPriority(Alert.Priority.LOW);
                    alerts.add(alert);
                }
            }
        return  alerts;
    }

    private boolean checkTirePressure(int pressure){
        if(pressure < 32 || pressure > 36){
            return true;
        }
        return  false;
    }
}
