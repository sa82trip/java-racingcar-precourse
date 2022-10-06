package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RaceView {
    private static String getString() {
        return Console.readLine();
    }

    private static void printQuestion(String question) {
        System.out.println(question);
    }

    public String askUserWithMessage(String question) {
        printQuestion(question);
        return getString();
    }

}
