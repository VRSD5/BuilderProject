package placeholder.houseParts;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


import java.awt.geom.Point2D;
import java.util.ArrayList;

import static placeholder.scripts.findMinimumDistance;

public class Wall {
    private final double[] x_coords;
    private final double[] y_coords;
    private Color color;
    private int width;

    private ArrayList<Window> windows = new ArrayList<>();

    public Wall(ArrayList<double[]> points) {
        x_coords = points.stream().mapToDouble(x -> x[0]).toArray();
        y_coords = points.stream().mapToDouble(y -> y[1]).toArray();
    }

    public Wall(double[] x_coords, double[] y_coords) {
        this.x_coords = x_coords;
        this.y_coords = y_coords;
    }

    public void setWallColor(Color color) {
        this.color = color;

    }
    public void setWidth(int width) {
        this.width = width;
    }

    public Wall copy() {
        return new Wall(x_coords, y_coords);
    }


    public void render(GraphicsContext gc) {

        gc.setStroke(color);
        gc.setLineWidth(width);
        gc.strokePolyline(x_coords, y_coords, x_coords.length);

        for (Window window : windows) {
            window.render(gc);
        }
    }

    public void addWindow(Window window) {
        windows.add(window);
    }

    public double[] nearestPoint(double[] point) {
        return findMinimumDistance(x_coords, y_coords, point, (y_coords[y_coords.length - 1] == y_coords[0] && x_coords[x_coords.length - 1] == x_coords[0]));
    }
}
