package placeholder.houseParts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Flooring {
    private final double[] x_coords;
    private final double[] y_coords;

    private Color color;

    public Flooring(ArrayList<double[]> points) {
        x_coords = points.stream().mapToDouble(x -> x[0]).toArray();
        y_coords = points.stream().mapToDouble(y -> y[1]).toArray();
    }

    public Flooring(double[] x_coords, double[] y_coords) {
        this.x_coords = x_coords;
        this.y_coords = y_coords;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Flooring copy() {
        return new Flooring(x_coords, y_coords);
    }

    public void render(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setFill(color);
        gc.fillPolygon(x_coords, y_coords, x_coords.length);
    }
}
