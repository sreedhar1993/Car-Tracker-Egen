package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Readings;

import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
public interface ReadingService {
    List<Readings> findAll();

    Readings create(Readings readings);

    List<Alert> checkForAlerts(Readings readings);

}
