package placeholder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static final int x_size = 250;
    public static final int y_size = 250;

    private Director director = new Director();
    private House house;

    private Stage stage;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;

    private double[] prev;
    private ArrayList<double[]> prevs = new ArrayList<>();
    private ArrayList<double[]> lines = new ArrayList<>();

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        VBox main = new VBox();
        canvas = new Canvas(x_size, y_size);
        gc = canvas.getGraphicsContext2D();
        main.getChildren().addAll(canvas);

        scene = new Scene(main);
        scene.setOnKeyPressed(this::keyPress);
        scene.setOnMouseClicked(this::mouseClick);
        scene.setOnMouseMoved(this::mouseMove);
        stage.setScene(scene);

        stage.show();
    }

    private void keyPress(KeyEvent event) {
        switch (event.getText()) {
            case "B":

        }
    }

    private void mouseClick(MouseEvent event) {
        System.out.println(event.getButton());
        if (event.getButton() == MouseButton.PRIMARY) {
            if (prev == null) {
                prev = new double[]{event.getSceneX(), event.getSceneY()};
            } else {
                prevs.add(new double[]{prev[0], prev[1], event.getSceneX(), event.getSceneY()});
                prev = new double[]{event.getSceneX(), event.getSceneY()};
            }
        } else if (event.getButton() == MouseButton.SECONDARY) {
            if (prev != null) {
                prevs.add(new double[]{prev[0], prev[1], event.getSceneX(), event.getSceneY()});
                lines.addAll(prevs);
                prev = null;
                prevs = new ArrayList<>();
                render();
            }
        }
    }

    private void mouseMove(MouseEvent event) {
        render();
        if (prev != null) {
            strokeLineArray(new double[]{prev[0], prev[1], event.getSceneX(), event.getSceneY()});
        }
    }

    private void strokeLineArray(double[] array) {
        gc.strokeLine(array[0], array[1], array[2], array[3]);
    }

    private void strokePointList(ArrayList<double[]> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            gc.strokeLine(points.get(i)[0], points.get(i)[1], points.get(i + 1)[0], points.get(i + 1)[1]);
        }
    }

    private void render() {
        gc.setFill(Paint.valueOf("white"));
        gc.fillRect(0, 0, x_size, y_size);
        prevs.forEach(this::strokeLineArray);
        lines.forEach(this::strokeLineArray);
    }
}
