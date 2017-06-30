package io.egen.controller;

import io.egen.entity.Alert;
import io.egen.entity.Readings;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingsController {


    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll() {
        return readingService.findAll() ;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alert> create(@RequestBody Readings readings) {
        readingService.create(readings);
        return readingService.checkForAlerts(readings);
    }

}
