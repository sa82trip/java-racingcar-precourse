package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ConstantNumber;

public class Car {
    private final Identification name;
    private final CarPosition position;

    public Car(Identification name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public CarPosition getPosition() {
        return position;
    }

    public CarPosition move() {
        position.modifyPosition(new GameNumber(
                Randoms.pickNumberInRange(ConstantNumber.START_INCLUSIVE, ConstantNumber.END_INCLUSIVE)));
        return this.position;
    }

    public Identification getName() {
        return name;
    }
}
