package racingcar.controller;

import java.util.List;
import racingcar.constant.InfoMessage;
import racingcar.model.Car;
import racingcar.model.GameNumber;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class RaceController {
    private final RaceView view;
    private final RaceService raceService;
    private List<Car> cars;
    private GameNumber gameNumber;

    public RaceController(RaceView view, RaceService raceService) {
        this.view = view;
        this.raceService = raceService;
        this.cars = null;
    }

    public void run() {
        while (cars == null) {
            cars = raceService.returnCars(view.askUserWithMessage(InfoMessage.WRITE_CAR_NAME));
        }
        while (gameNumber == null) {
            gameNumber = GameNumber.of((view.askUserWithMessage(InfoMessage.TRIAL_COUNT)));
        }
    }
}
