package placeholder;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class scripts {
    public static double distance(double a, double b, double c, double d) {
        return sqrt((a - c) * (a - c) + (b - d) * (b - d));
    }

    public static double distance(double[] a, double[] b) {
        return distance(a[0], a[1], b[0], b[1]);
    }

    public static double[] findMinimumDistance(double[] x_coords, double[] y_coords, double[] point, boolean closed) {
        double[] p = new double[2];
        double[] min_pt = new double[2];
        double a, b, c, d, dot, len_sq, cos_theta = -1, min_dist = 100000, dist;
        int i, j;
        int n = x_coords.length;

        for (i = closed ? 0 : 1, j = closed ? n - 1 : 0; i < n; j = i++) {
            a = point[0] - x_coords[i];
            b = point[1] - y_coords[i];
            c = x_coords[j] - x_coords[i];
            d = y_coords[j] - y_coords[i];
            dot = a * c + b * d;
            len_sq = c * c + d * d;
            cos_theta = dot / len_sq;
            if (cos_theta < 0) {
                p[0] = x_coords[i];
                p[1] = y_coords[i];
            } else if (cos_theta > 1) {
                p[0] = x_coords[j];
                p[1] = y_coords[j];
            } else {
                p[0] = x_coords[i] + cos_theta * c;
                p[1] = y_coords[i] + cos_theta * d;
            }
            double dx = point[0] - p[0];
            double dy = point[1] - p[1];
            dist = sqrt(dx * dx + dy * dy);

            if (dist < min_dist) {
                min_pt[0] = p[0];
                min_pt[1] = p[1];
                min_dist = dist;
            }
        }
        return min_pt;
    }


}
