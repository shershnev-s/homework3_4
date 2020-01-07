package by.tut.shershnev_s.service.impl;

import by.tut.shershnev_s.repository.model.Car;
import by.tut.shershnev_s.repository.model.CarModel;
import by.tut.shershnev_s.service.CarService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import by.tut.shershnev_s.util.RandomUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarServiceImpl implements CarService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void runFirstTask() {
        String filePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "createDatabase.txt";
        File file = new File(filePath);
        printSQLCommandsFromFile(file);
    }

    @Override
    public void runSecondTask() {
        int carQuantity = 10;
        List<Car> list = getRandomCarList(carQuantity);
    }

    private void printSQLCommandsFromFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logger.info(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File cant be read: " + e.getMessage());
        }
    }

    private List<Car> getRandomCarList(int quantity) {
        int minNumberForRandom = 1;
        int maxNumberForRandom = 3;
        int randomNumberForEnumSelect;
        List<Car> list = new ArrayList<>();
        Car car;
        for (int i = 0; i < quantity; i++) {
            randomNumberForEnumSelect = RandomUtil.getRandom(minNumberForRandom, maxNumberForRandom);
            switch (randomNumberForEnumSelect) {
                case 1: {
                    car = new Car("name" + i, i, CarModel.BMW);
                    list.add(car);
                    break;
                }
                case 2: {
                    car = new Car("name" + i, i, CarModel.Mercedes);
                    list.add(car);
                    break;
                }
                case 3: {
                    car = new Car("name" + i, i, CarModel.Reno);
                    list.add(car);
                    break;
                }
            }
        }
        return list;
    }


}
