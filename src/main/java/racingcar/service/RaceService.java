package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarPosition;
import racingcar.model.Cars;
import racingcar.model.Identification;

public class RaceService {

    public Cars returnCars(String carsNameInput) {
        String[] splitCars = carsNameInput.split(",");
        try {
            return createCars(splitCars);
        } catch (IllegalArgumentException e) {
            System.out.printf("%s: %n", e.getMessage());
        }
        return null;
    }

    private Cars createCars(String[] splitCars) {
        List<Car> cars = new ArrayList<>();
        for (String splitCar : splitCars) {
            cars.add(createCar(splitCar));
        }
        return new Cars(cars);
    }

    private Car createCar(String splitCar) {
        return new Car(new Identification(splitCar));
    }

    public String makeDashes(CarPosition position) {
        StringBuilder dashes = new StringBuilder();
        for (int i = 0; i < position.getPosition().size(); i++) {
            dashes.append(position.getPosition().get(i));
        }
        return dashes.toString();
    }

    public void moveAndShow(Cars cars) {
        for (Car car :
                cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName().getName(), makeDashes(car.move()));
        }
        System.out.println();
    }
}
