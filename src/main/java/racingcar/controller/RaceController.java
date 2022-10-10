package racingcar.controller;

import racingcar.constant.InfoMessage;
import racingcar.model.Cars;
import racingcar.model.GameNumber;
import racingcar.service.RaceService;
import racingcar.view.RaceView;

public class RaceController {
    private final RaceView view;
    private final RaceService raceService;
    private Cars cars;
    private GameNumber gameNumber;

    public RaceController(RaceView view, RaceService raceService) {
        this.view = view;
        this.raceService = raceService;
        this.cars = null;
        this.gameNumber = null;
    }

    public void run() {
        cars = getCarNamesFromUser();
        gameNumber = getGameNumberFromUser();

        view.printMessage(InfoMessage.GAME_RESULT);
        cars = raceService.beginRace(gameNumber, cars);
        view.reportCurrentStatus(gameNumber, cars);

        view.printWinners(raceService.makePrintableWinners(raceService.detectWinner(cars)));
    }

    private GameNumber getGameNumberFromUser() {
        while (gameNumber == null) {
            gameNumber = GameNumber.of((view.askQuestionWithMessage(InfoMessage.TRIAL_COUNT).getInput()));
        }
        return gameNumber;
    }

    private Cars getCarNamesFromUser() {
        while (cars == null) {
            cars = raceService.returnCars(view.askQuestionWithMessage(InfoMessage.WRITE_CAR_NAME).getInput());
        }
        return cars;
    }
}

