package by.tut.shershnev_s.repository.model;

public class Car {
    private String name;
    private int engineCapacity;
    private CarModel carModel;

    public Car(String name, int engineCapacity, CarModel carModel) {
        this.name = name;
        this.engineCapacity = engineCapacity;
        this.carModel = carModel;
    }

    public String getName() {
        return name;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getCarModel() {
        return carModel + "";
    }
}
