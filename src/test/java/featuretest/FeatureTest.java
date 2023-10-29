package featuretest;

import Model.*;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class FeatureTest {

    @Test
    void 자동차_이름_파싱() {
        String testCarNames = "car1,car2,car3";
        RaceCarNames raceCarNames = new RaceCarNames(testCarNames);

        List<String> actualCarNames = raceCarNames.parseCarNamesFromRaceCarInput();
        List<String> expectedCarNames = List.of("car1", "car2", "car3");

        assertThat(actualCarNames).containsExactlyElementsOf(expectedCarNames);
    }

    @Test
    void 자동차_이름_다섯글자_초과시_예외발생() {
        String testRaceCarNames = "mycar1,car2,car3";
        InputStream inputStream = new ByteArrayInputStream(testRaceCarNames.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(Application::receiveRaceCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력받고_자동차리스트_객체에_저장() {
        String testInput = "car1,car2,car3";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        Application.receiveRaceCarNames();

        CarList actualCarList = Application.getCarList();
        List<Car> actualCars = actualCarList.getCarList();
        List<Car> expectedCars = List.of(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        );

        assertThat(actualCars).containsExactlyElementsOf(expectedCars);
    }

    @Test
    void 시도할_회수_입력받고_시도횟수_객체에_저장() {
        String testInput = "5";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        Application.receiveTryCount();

        TryCount actualTryCount = Application.getTryCount();
        TryCount expectedTryCount = new TryCount("5");

        assertThat(actualTryCount).isEqualTo(expectedTryCount);
    }


//
//    @Test
//    void 자동차_이름_비어있음() {
//        String testRaceCarNames = "mycar1,  ,car3";
//        InputStream inputStream = new ByteArrayInputStream(testRaceCarNames.getBytes());
//        System.setIn(inputStream);
//
//        assertThatThrownBy(Application::receiveRaceCarNames)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//

//

//
//    @Test
//    void 시도_횟수_숫자_아님() {
//        String testTryCount = "car1";
//        InputStream inputStream = new ByteArrayInputStream(testTryCount.getBytes());
//        System.setIn(inputStream);
//
//        assertThatThrownBy(Application::receiveTryCount)
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 자동차_전진() {
//        CarPosition actualObj = new CarPosition(3);
//        actualObj.moveForward();
//        CarPosition expectedObj = new CarPosition(4);
//
//        assertThat(actualObj).isEqualTo(expectedObj);
//    }
//
//    @Test
//    void 랜덤_값_생성() {
//        Car actualObj = new Car("car1");
//        actualObj.generateRandomNumber();
//
//        boolean actualResult = actualObj.isRandomNumberInRange0to9();
//        boolean expectedResult = true;
//
//        assertThat(actualResult).isEqualTo(expectedResult);
//    }
}
