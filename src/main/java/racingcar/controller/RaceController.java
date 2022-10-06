package racingcar.controller;

import java.util.List;
import racingcar.constant.InfoMessage;
import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class RaceController {
    private final RaceView view;
    private final RaceService raceService;
    private List<Car> cars;

    public RaceController(RaceView view, RaceService raceService) {
        this.view = view;
        this.raceService = raceService;
    }

    public void run() {
        while (cars == null) {
            try {
                String carsNameInput = view.askUserWithMessage("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
                cars = raceService.createCars(carsNameInput);
            } catch (IllegalArgumentException e) {
                System.out.printf("%s invalid car name%n", InfoMessage.ERROR_MESSAGE_BEGIN.label());
            }
        }
    }
}
