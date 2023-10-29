package Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarList {
    private List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public int getSize() {
        return carList.size();
    }

    public Car getCar(int idx) {
        return carList.get(idx);
    }


    /**
     * 테스트용 메서드
     */
    public List<Car> getCarList() {
        return carList;
    }
}
