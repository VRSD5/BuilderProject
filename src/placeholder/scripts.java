package placeholder;

public class scripts {
    public static double distance(double a, double b, double c, double d) {
        return Math.sqrt((a - c) * (a - c) + (b - d) * (b - d));
    }

    public static double distance(double[] a, double[] b) {
        return distance(a[0], a[1], b[0], b[1]);
    }
}
