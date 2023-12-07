package placeholder.houseParts;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;


import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Wall {
    private double[] x_coords;
    private double[] y_coords;
    private boolean closed;
    private boolean exterior;

    private int style = 0;

    public Wall(ArrayList<double[]> points, boolean exterior, boolean closed) {
        x_coords = points.stream().mapToDouble(x -> x[0]).toArray();
        y_coords = points.stream().mapToDouble(y -> y[1]).toArray();
        this.closed = closed;
        this.exterior = exterior;

    }


    public void setStyle(int style) {
        this.style = style;
    }
    public void render(GraphicsContext gc) {
        gc.setStroke(Paint.valueOf("blue"));
        gc.strokePolyline(x_coords, y_coords, x_coords.length);
    }
}
