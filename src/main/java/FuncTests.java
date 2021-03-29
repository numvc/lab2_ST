import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

public class FuncTests {

    @ParameterizedTest
    @ValueSource(doubles = {-1.1})
    void checkSinFunc(double value) {
        Assertions.assertEquals(Math.sin(value) , Function.sin(value), 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1})
    void checkLnFunc(double value) {
        Assertions.assertEquals(Math.log(value) , Function.ln(value), 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.21, -0.11, -0.45, -0.3111, -0.09})
    void checkMainFuncP(double value)  {
        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.000001, 0.999999, Math.PI, Math.PI*3/2})
    void checkMainFuncBorders(double value) {
        Map<FunctionsList, Boolean> map = new HashMap<>();
        map.put(FunctionsList.COS, true); // not stubbed
        map.put(FunctionsList.SEC, false); // stubbed
        map.put(FunctionsList.COT, false);
        map.put(FunctionsList.SIN, false);
        map.put(FunctionsList.LN, false);
        map.put(FunctionsList.LOG, false);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);

        map.put(FunctionsList.SEC, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);

        map.put(FunctionsList.COT, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);

        map.put(FunctionsList.SIN, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);


        map.put(FunctionsList.LN, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);


        map.put(FunctionsList.LOG, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.331, 0.09, 0.8})
    void checkMainFuncPositive(double value) {
        Map<FunctionsList, Boolean> map = new HashMap<>();
        map.put(FunctionsList.COS, true); // not stubbed
        map.put(FunctionsList.SEC, false); // stubbed
        map.put(FunctionsList.COT, false);
        map.put(FunctionsList.SIN, false);
        map.put(FunctionsList.LN, false);
        map.put(FunctionsList.LOG, false);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);

        map.put(FunctionsList.SEC, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);

        map.put(FunctionsList.COT, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);

        map.put(FunctionsList.SIN, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);


        map.put(FunctionsList.LN, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);


        map.put(FunctionsList.LOG, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value) , Function.mainFunc(value), 0.5);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.21, -0.11, -0.45, -0.3111, -0.09})
    void checkMainFuncNegative(double value) {
        Map<FunctionsList, Boolean> map = new HashMap<>();
        map.put(FunctionsList.COS, true); // not stubbed
        map.put(FunctionsList.SEC, false); // stubbed
        map.put(FunctionsList.COT, false);
        map.put(FunctionsList.SIN, false);
        map.put(FunctionsList.LN, false);
        map.put(FunctionsList.LOG, false);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value), Function.mainFunc(value), 0.5);

        map.put(FunctionsList.SEC, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value), Function.mainFunc(value), 0.5);

        map.put(FunctionsList.COT, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value), Function.mainFunc(value), 0.5);

        map.put(FunctionsList.SIN, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value), Function.mainFunc(value), 0.5);


        map.put(FunctionsList.LN, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value), Function.mainFunc(value), 0.5);


        map.put(FunctionsList.LOG, true);
        Function.map = map;

        Assertions.assertEquals(FunctionStub.mainFunc(value), Function.mainFunc(value), 0.5);
    }
}
