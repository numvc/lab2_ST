public interface IntegrationTest {
    static double cot(double x) {
        return cos(x) / sin(x);
    }

    static double sin(double x) {
        return Math.sin(x);
    }

    static double cos(double x) {
        return Math.sqrt(1 - sin(x) * sin(x));
    }

    static double sec(double x) {
        return 1 / cos(x);
    }

    static double log(double x, int e) {
        //x>0 e>0 e!=1
        return ln(x) / ln(e);
    }

    static double ln(double x) {
        return Math.log(x);
    }
}
