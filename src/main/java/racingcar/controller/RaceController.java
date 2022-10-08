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
    }

    public void run() {
        while (cars == null) {
            cars = raceService.returnCars(view.askUserWithMessage(InfoMessage.WRITE_CAR_NAME));
        }
        while (gameNumber == null) {
            gameNumber = GameNumber.of((view.askUserWithMessage(InfoMessage.TRIAL_COUNT)));
        }
        view.printMessage(InfoMessage.GAME_RESULT);
        for (int i = 0; i < gameNumber.getNumber(); i++) {
            raceService.move(cars);
            raceService.displayStatus(cars);
        }
//        cars.getCars().sort(Comparator.comparingInt(a -> a.getPosition().getPosition().size()));

        Cars winners = raceService.detectWinner(cars);
        if (winners.getCars().size() == 1) {
            view.printMessage(String.format("%s %s", InfoMessage.WINNER, winners.getCars().get(0).getNameInString()));
        }
        if (winners.getCars().size() > 1) {
            //TODO: make proper print for co-winner
            winners.getCars().forEach(o -> System.out.println(o.getNameInString()));
        }
        //TODO: if there are more than one winner than?
    }

}
