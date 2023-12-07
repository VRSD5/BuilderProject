package placeholder.houseParts;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Window {
    private double[] pointA;
    private double[] pointB;

    private Color windowColor;
    private Color wallColor;
    private int width;
    private int sillWidth;

    public Window(double[] pointA, double[] pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public void setWindowColor(Color color) {
        this.windowColor = color;
    }

    public void setSillColor(Color color) {
        wallColor = color;
    }

    public void setWindowWidth(int width) {
        this.width = width;
    }

    public void setSillWidth(int width) {
        this.sillWidth = width;
    }

    public double[] getPointA() {
        return pointA;
    }

    public Window copy() {
        return new Window(pointA, pointB);
    }

    public void render(GraphicsContext gc) {
        gc.setStroke(wallColor);
        gc.setLineWidth(sillWidth);
        gc.strokeLine(pointA[0], pointA[1], pointB[0], pointB[1]);

        gc.setStroke(windowColor);
        gc.setLineWidth(width);
        gc.strokeLine(pointA[0], pointA[1], pointB[0], pointB[1]);
    }
}
