package placeholder.houseParts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Flooring {
    private final double[] x_coords;
    private final double[] y_coords;

    public Flooring(ArrayList<double[]> points) {
        x_coords = points.stream().mapToDouble(x -> x[0]).toArray();
        y_coords = points.stream().mapToDouble(y -> y[1]).toArray();
    }

    public void setStyle(int style) {

    }

    public void render(GraphicsContext gc) {
        gc.setStroke(Paint.valueOf("red"));
        gc.setFill(Paint.valueOf("red"));
        gc.fillPolygon(x_coords, y_coords, x_coords.length);
    }
}
