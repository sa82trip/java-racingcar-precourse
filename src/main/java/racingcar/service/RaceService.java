package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RaceService {

    public static final int ZERO = 0;
    public static final int INDEX_ZERO = 0;

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
        for (Car car :
                cars.getCars()) {
            car.move();
        }
        System.out.println();
    }

    public Cars detectWinner(Cars competitors) {
        int max = ZERO;
        Cars winnerCars = new Cars(new ArrayList<>());
        for (Car car : competitors.getCars()) {
            max = getMax(max, winnerCars, car);
            addCoWinner(max, winnerCars, car);
        }
        return winnerCars;
    }

    protected void addCoWinner(int max, Cars winnerCars, Car car) {
        if (max == car.getPositionInteger() && !winnerCars.getCars().get(INDEX_ZERO).getNameInString()
                .equals(car.getNameInString())) {
            winnerCars.getCars().add(car);
        }
    }

    protected int getMax(int max, Cars winnerCars, Car car) {
        if (max == ZERO || max < car.getPositionInteger()) {
            max = car.getPositionInteger();
            winnerCars.getCars().clear();
            winnerCars.getCars().add(car);
        }
        return max;
    }

    public String makePrintableWinners(Cars winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (Car car :
                winners.getCars()) {
            winnerNames.append(", ");
            winnerNames.append(car.getNameInString());
        }
        return winnerNames.substring(1).trim();
    }

}

