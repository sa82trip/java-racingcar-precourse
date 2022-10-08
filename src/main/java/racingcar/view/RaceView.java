package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

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

}
