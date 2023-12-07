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

//TODO HouseEditor and HouseImage as things to build from seperate builders

public class Main extends Application {
    public static final int x_size = 250;
    public static final int y_size = 250;

    private Director director = new Director();
    private House house;

    private int style = 0;
    private int mode = 0;

    private Stage stage;
    private Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;

    private double[] prev;
    private ArrayList<double[]> prevs = new ArrayList<>();


    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        VBox main = new VBox();
        canvas = new Canvas(x_size, y_size);
        gc = canvas.getGraphicsContext2D();
        main.getChildren().addAll(canvas);

        director.setBuilder(new EditorBuilder(0));

        scene = new Scene(main);
        scene.setOnKeyPressed(this::keyPress);
        scene.setOnMouseClicked(this::mouseClick);
        scene.setOnMouseMoved(this::mouseMove);
        stage.setScene(scene);

        stage.show();
    }

    private void keyPress(KeyEvent event) {
        System.out.println(event.getText());
        switch (event.getText()) {
            case "b":
                house = director.assemble();
                render();
                break;
            case "h":
                style = (style + 1) % 4;
                director.setBuilder(new EditorBuilder(style));

                break;
            case "r":
                house = null;
                prevs = new ArrayList<>();
                prev = null;
                mode = 0;
                director.reset();
                director.setBuilder(new EditorBuilder(style));
                break;
            case "m":
                mode = (mode + 1) % 3;
                System.out.println(mode);
                break;

        }
        render();
    }

    private void mouseClick(MouseEvent event) {
        System.out.println(event.getButton());
        if (event.getButton() == MouseButton.PRIMARY) {
            if (mode == 2 && house != null) {
                prev = house.findNearestWall(new double[]{event.getSceneX(), event.getSceneY()});
            } else {
                prev = new double[]{event.getSceneX(), event.getSceneY()};
                prevs.add(new double[]{prev[0], prev[1]});
            }


        } else if (event.getButton() == MouseButton.SECONDARY) {
            if (prev != null) {
                prevs.add(new double[]{event.getSceneX(), event.getSceneY()});
                if (scripts.distance(prevs.get(0), prevs.get(prevs.size() - 1)) <= 10) {
                    switch (mode) {
                        case 0 -> director.addWall(prevs, true, true);
                        case 1 -> director.addFloor(prevs, true);
                        case 2 -> {
                            if (house != null) {
                                director.addWindow(prev, house.findNearestWall(new double[]{event.getSceneX(), event.getSceneY()}));
                            }
                        }
                    }
                } else {
                    switch (mode) {
                        case 0 -> director.addWall(prevs, true, false);
                        case 1 -> director.addFloor(prevs, false);
                        case 2 -> {
                            if (house != null) {
                                director.addWindow(prev, house.findNearestWall(new double[]{event.getSceneX(), event.getSceneY()}));
                            }
                        }
                    }

                }
                house = director.assemble();
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
        gc.setStroke(Paint.valueOf("black"));
        gc.setLineWidth(1);
        gc.strokeLine(array[0], array[1], array[2], array[3]);
    }

    private void strokePointList(ArrayList<double[]> points) {
        gc.setStroke(Paint.valueOf("black"));
        gc.setLineWidth(1);
        for (int i = 0; i < points.size() - 1; i++) {
            gc.strokeLine(points.get(i)[0], points.get(i)[1], points.get(i + 1)[0], points.get(i + 1)[1]);
        }
    }

    private void render() {



        if (house != null) {
            house.render(gc);
        } else {
            gc.setFill(Paint.valueOf("white"));
            gc.fillRect(0, 0, x_size, y_size);
        }

        strokePointList(prevs);
    }
}
