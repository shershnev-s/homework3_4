package by.tut.shershnev_s.repository;

import by.tut.shershnev_s.repository.model.Car;

import java.sql.Connection;
import java.sql.SQLException;

public interface CarRepository {
    Car add(Connection connection, Car car) throws SQLException;
}
