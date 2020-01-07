package by.tut.shershnev_s;

import by.tut.shershnev_s.service.CarService;
import by.tut.shershnev_s.service.impl.CarServiceImpl;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CarService CarService = new CarServiceImpl();
        CarService.runFirstTask();
        CarService.runSecondTask();
    }
}
