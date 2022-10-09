package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.InfoMessage;
import racingcar.model.Car;
import racingcar.model.CarPosition;
import racingcar.model.Cars;

public class RaceView {
    //TODO:: method naming
    private String getString() {
        return Console.readLine();
    }

    public void printMessage(String question) {
        System.out.println(question);
    }

    public String askUserWithMessage(String question) {
        printMessage(question);
        return getString();
    }

    public void displayStatus(Cars cars) {
        for (Car car :
                cars.getCars()) {
            System.out.printf("%s : %s%n", car.getName().getName(), makeDashes(car.getPosition()));
        }
    }

    public String makeDashes(CarPosition position) {
        StringBuilder dashes = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            dashes.append("-");
        }
        return dashes.toString();
    }

    public void printWinners(boolean isOkayToPrint, String winners) {
        if (isOkayToPrint) {
            this.printMessage(String.format("%s %s", InfoMessage.WINNER,
                    winners));
        }
    }

}
