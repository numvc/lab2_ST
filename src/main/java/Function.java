import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function implements IntegrationTest {

    private static double e = 0.01;
    protected static Map<FunctionsList, Boolean> map = new HashMap<>();

    public static double mainFunc(double x) {
        double result;
        if (x <= 0) {
            if (Math.abs(x % Math.PI) < e || Math.abs(x % (3 * Math.PI / 2)) < e) result = Double.NaN; // ÎÄÇ
            else
                result = (Math.pow((cot(x) * sec(x)), 2) - sin(x)) * (sec(x) + sec(x) - Math.pow(cos(x) - cot(x), 2));
        } else {
            if (Math.abs(x - 1) < e) result = Double.NaN; // ÎÄÇ
            else
                result = (((((log(x, 3) + log(x, 5)) - log(x, 3)) / ((Math.pow(ln(x), 2)) - (log(x, 10) * ln(x)))) /
                        (log(x, 5) - log(x, 2))) * (((log(x, 3) + (Math.pow(log(x, 5), 3))) / (log(x, 2) * log(x, 2))) - log(x, 10)));
        }

        List<String[]> stringArray = new ArrayList<>();
        String[] arr = new String[]{String.valueOf(x), String.valueOf(result)};
        stringArray.add(arr);
        try {
            CsvWritter.csvWriterOneByOne(stringArray);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public static double cot(double x) {
        if (map.isEmpty() || map.get(FunctionsList.COT))
            return cos(x) / sin(x);

        return FunctionStub.cot(x);
    }

    public static double sec(double x) {    // x!= (2k+1)* pi/2
        if (map.isEmpty() || map.get(FunctionsList.SEC))
            return 1 / cos(x);

        return FunctionStub.sec(x);
    }

    public static double cos(double x) {

        if (map.isEmpty() || map.get(FunctionsList.COS))
            return Math.sqrt(1 - sin(x) * sin(x));

        return FunctionStub.cos(x);
    }

    public static double sin(double x) {

        if (map.isEmpty() || map.get(FunctionsList.SIN)) {

            double result, prevResult;
            int k = 0;

            prevResult = Double.MAX_VALUE;
            result = Math.pow(-1, k) * Math.pow(x, 2 * k + 1) / fact(2 * k + 1);
            k++;

            while (Math.abs(result - prevResult) > e) {
                prevResult = result;
                result += Math.pow(-1, k) * Math.pow(x, 2 * k + 1) / fact(2 * k + 1);
                k++;
            }

            return result;
        }
        return FunctionStub.sin(x);
    }

    public static double log(double x, int e) { //x>0 e>0 e!=1
        if (map.isEmpty() || map.get(FunctionsList.LOG))
            return ln(x) / ln(e);

        return FunctionStub.log(x, e);
    }

    public static double ln(double x) {

        if (map.isEmpty() || map.get(FunctionsList.LN)) {

//            double result, prevResult;
//            int n = 1;
//
//            prevResult = Double.MAX_VALUE;
//            result = Math.pow(-1, n - 1) * Math.pow(x, n) / n;
//            n++;
//            while(Math.abs(prevResult - result) > e){
//                prevResult = result;
//                result += Math.pow(-1, n - 1) * Math.pow(x, n) / n;
//                n++;
//            }
//            return result;

            if (x <= 0) return Double.NaN;
            double result, prevResult;
            int k = 1;

            result = 1 / k * Math.pow((x - 1) / (x + 1), k);
            k += 2;

            prevResult = Double.MAX_VALUE;

            while (Math.abs(result - prevResult) > e) {
                prevResult = result;
                result += 1 / k * Math.pow((x - 1) / (x + 1), k);
                k += 2;
            }
            return 2 * result;
        }
        return FunctionStub.ln(x);
    }

    public static int fact(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
