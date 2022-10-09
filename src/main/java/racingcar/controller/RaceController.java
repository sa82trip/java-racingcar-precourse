package racingcar.controller;

import racingcar.constant.ConstantNumber;
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
    }

    public void run() {
        getCarNamesFromUser();
        getGameNumberFromUser();

        view.printMessage(InfoMessage.GAME_RESULT);
        for (int i = ConstantNumber.MIN_INDEX; i < gameNumber.getNumber(); i++) {
            raceService.move(cars);
            view.displayStatus(cars);
        }

        Cars winners = raceService.detectWinner(cars);
        view.printWinners(winners.isSoleWinner(winners),
                winners.getCars().get(ConstantNumber.MIN_INDEX).getNameInString());
        view.printWinners(winners.isMultipleWinner(winners), raceService.makePrintableWinners(winners));
    }

    private void getGameNumberFromUser() {
        while (gameNumber == null) {
            gameNumber = GameNumber.of((view.askUserWithMessage(InfoMessage.TRIAL_COUNT)));
        }
    }

    private void getCarNamesFromUser() {
        while (cars == null) {
            cars = raceService.returnCars(view.askUserWithMessage(InfoMessage.WRITE_CAR_NAME));
        }
    }
}

