package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ConstantNumber;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameNumber;

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
        List<String> carNames = new ArrayList<>(Arrays.asList(splitCars));
        return new Cars(carNames);
    }


    public void move(Cars cars) {
        for (Car car : cars.getValue()) {
            car.move();
        }
        System.out.println();
    }

    public Cars detectWinner(Cars competitors) {
        int max = ConstantNumber.ZERO;
        Cars winnerCars = new Cars(new ArrayList<>());
        for (Car car : competitors.getValue()) {
            max = getMax(max, winnerCars, car);
            addCoWinner(max, winnerCars, car);
        }
        return winnerCars;
    }

    protected void addCoWinner(int max, Cars winnerCars, Car car) {
        if (max == car.getPositionInteger() && !winnerCars.getValue().get(0).getNameInString()
                .equals(car.getNameInString())) {
            winnerCars.getValue().add(car);
        }
    }

    protected int getMax(int max, Cars winnerCars, Car car) {
        if (max == ConstantNumber.ZERO || max < car.getPositionInteger()) {
            max = car.getPositionInteger();
            winnerCars.getValue().clear();
            winnerCars.getValue().add(car);
        }
        return max;
    }

    public String makePrintableWinners(Cars winners) {
        if (winners.isSoleWinner(winners)) {
            return winners.getValue().get(0).getNameInString();
        }
        StringBuilder winnerNames = new StringBuilder();
        for (Car car : winners.getValue()) {
            winnerNames.append(", ");
            winnerNames.append(car.getNameInString());
        }
        return winnerNames.substring(ConstantNumber.EXCLUDE_FIRST_LETTER).trim();
    }

    public Cars beginRace(GameNumber gameNumber, Cars cars) {
        for (int i = 0; i < gameNumber.getNumber(); i++) {
            move(cars);
        }
        return cars;
    }


}

