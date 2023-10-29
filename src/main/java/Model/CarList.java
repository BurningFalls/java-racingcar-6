package Model;

import camp.nextstep.edu.missionutils.Randoms;

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

    public void playGame() {
        for (int i = 0; i < carList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                Car car = carList.get(i);
                car.moveForward();
            }
        }
    }

    public CarList calculateRaceWinners() {
        CarList raceWinners = new CarList();

        int maxPosition = 0;
        for (Car car : carList) {
            CarPosition carPosition = car.getPosition();
            int position = carPosition.getCarPosition();
            if (maxPosition < position) {
                maxPosition = position;
            }
        }

        for (Car car : carList) {
            CarPosition carPosition = car.getPosition();
            int position = carPosition.getCarPosition();
            if (maxPosition == position) {
                raceWinners.addCar(car);
            }
        }

        return raceWinners;
    }

    public void printCarPositions() {
        for (Car car : carList) {
            car.printCarName();
            System.out.print(" : ");
            car.printCarPosition();
        }
        System.out.println();
    }

    public void printCarNames() {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.printCarName();
            if (i != carList.size() - 1) {
                System.out.print(", ");
            }
        }
    }


    /**
     * 테스트용 메서드
     */
    public List<Car> getCarList() {
        return carList;
    }
}
