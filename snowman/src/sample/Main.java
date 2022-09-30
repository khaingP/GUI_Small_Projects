package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Stage){
        Pane r= new Pane();
        Scene s=new Scene(r,Color.BLUE);
        Circle c1= new Circle();
        c1.centerXProperty().bind(s.widthProperty().divide(2));
        c1.centerYProperty().bind(s.heightProperty().divide(12));
        c1.radiusProperty().bind(s.heightProperty().divide(12));
        c1.setFill(Color.WHITE);


        Circle c2= new Circle();
        c2.centerXProperty().bind(s.widthProperty().divide(2));
        c2.centerYProperty().bind(s.heightProperty().divide(3));
        c2.radiusProperty().bind(c1.radiusProperty().multiply(2));
        c2.setFill(Color.WHITE);


        Circle c3= new Circle();
        c3.centerXProperty().bind(s.widthProperty().divide(2));
        c3.centerYProperty().bind(s.heightProperty().multiply(3).divide(4));
        c3.radiusProperty().bind(c1.radiusProperty().multiply(3));
        c3.setFill(Color.WHITE);

        r.getChildren().addAll(c1,c2,c3);
        Stage.setTitle("Do u wanna build a snowman?");
        Stage.setScene(s);
        Stage.show();
    }


}
