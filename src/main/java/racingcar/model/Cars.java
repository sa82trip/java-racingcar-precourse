package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> value;


    public Cars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        this.value = cars;
    }

    public Cars() {
        this.value = new ArrayList<>();
    }


    public List<Car> getValue() {
        return value;
    }

    public boolean isSoleWinner(Cars winners) {
        return winners.getValue().size() == 1;
    }
}
