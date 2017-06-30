package io.egen.repository;

import io.egen.entity.Readings;

import java.util.List;

/**
 * Created by Sreedhar on 6/29/2017.
 */
public interface ReadingRepository {
    List<Readings> findAll();

    Readings create(Readings readings);
}
