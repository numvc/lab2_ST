public class FunctionStub implements IntegrationTest{

    private static double e = 0.00001;

    public static double mainFunc(double x) {
        double result;
        if (x <= 0) {
            if (Math.abs(x % Math.PI) < e || Math.abs(x % (3 * Math.PI / 2)) < e) return Double.NaN; // ÎÄÇ
            result = (Math.pow((cot(x) * sec(x)), 2) - sin(x)) * (sec(x) + sec(x) - Math.pow(cos(x) - cot(x), 2));
        } else {
            if (Math.abs(x - 1) < e) return Double.NaN; // ÎÄÇ
            result = (((((log(x, 3) + log(x, 5)) - log(x, 3)) / ((Math.pow(ln(x), 2)) - (log(x, 10) * ln(x)))) /
                    (log(x, 5) - log(x, 2))) * (((log(x, 3) + (Math.pow(log(x, 5), 3))) / (log(x, 2) * log(x, 2))) - log(x, 10)));
        }


        return result;
    }

    public static double cot(double x) {
        return Math.cos(x)/sin(x);
    }

    public static double sec(double x) {
        // x!= (2k+1)* pi/2
        return 1/Math.cos(x);
    }

    public static double cos(double x) {
        return Math.cos(x);
    }

    public static double sin(double x) {
        return Math.sin(x);
    }

    public static double log(double x, int e) {
        //x>0 e>0 e!=1
        return Math.log(x)/Math.log(e);
    }

    public static double ln(double x) {
        return Math.log(x);
    }


}
