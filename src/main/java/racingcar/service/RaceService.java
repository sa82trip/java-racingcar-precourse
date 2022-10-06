package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Identification;

public class RaceService {

    public List<Car> createCars(String carsNameInput) {
        String[] splitCars = carsNameInput.split(",");
        List<Car> cars = new ArrayList<>();
        for (String splitCar : splitCars) {
            cars.add(new Car(new Identification(splitCar)));
        }
        return cars;
    }
}
