package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;


    public Cars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName :
                carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isMultipleWinner(Cars winners) {
        return winners.getCars().size() > 1;
    }

    public boolean isSoleWinner(Cars winners) {
        return winners.getCars().size() == 1;
    }
}
