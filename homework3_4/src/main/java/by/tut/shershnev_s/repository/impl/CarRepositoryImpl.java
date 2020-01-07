package by.tut.shershnev_s.repository.impl;

import by.tut.shershnev_s.repository.CarRepository;

import by.tut.shershnev_s.repository.model.Car;

import java.sql.*;

public class CarRepositoryImpl implements CarRepository {

    @Override
    public Car add(Connection connection, Car car) throws SQLException {
        try (
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO person(name, car_model, engine_capacity) VALUES (?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                )
        ) {
            statement.setString(0, car.getName());
            statement.setString(1, car.getCarModel());
            statement.setInt(2, car.getEngineCapacity());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating person failed, no rows affected.");
            }
            return car;
        }
    }
}
