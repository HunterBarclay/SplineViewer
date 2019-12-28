package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import org.team997coders.spartanlib.motion.path.MotionPath;
import org.team997coders.spartanlib.motion.path.MotionProcessor;
import org.team997coders.spartanlib.motion.path.Point;
import org.team997coders.spartanlib.motion.path.Waypoint;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Paint[] paints = new Paint[]{
        Color.RED, Color.BLUE, Color.YELLOW, Color.BLACK
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Fuck You Cunt");
        VBox box = new VBox();
        Scene scene = new Scene(box, 1000, 1000);
        scene.setFill(Color.DARKGREEN);

        Waypoint[] waypoints = new Waypoint[] {
            new Waypoint(new Point(0,0), new Point(0, 500)),
            new Waypoint(new Point(500, 500), new Point(1000, 0)),// new Waypoint(new Point(50, 0), new Point(0, 0))
            new Waypoint(new Point(500, 1000), new Point(250, 750)),
            new Waypoint(new Point(250, 0), new Point(500, -250))
        };

        MotionPath path = new MotionPath(waypoints);
        MotionProcessor proc = new MotionProcessor(path);
        //path.calculate(100);
        proc.genAdjustedPoints(50);
        Point[] points = proc.getPoints();

        List<LineTo> lines = new ArrayList<LineTo>();

        for (int i = 0; i < points.length; i++) {
            lines.add(getLine(points[i]));
        }

        Path test = new Path();
        test.getElements().add(new MoveTo(lines.get(0).getX(), lines.get(0).getY()));
        //test.getElements().addAll(new MoveTo(0, 0));
        test.setStroke(Color.WHITE);
        test.setStrokeWidth(3);

        lines.forEach(x -> {
            test.getElements().add(x);
            //box.getChildren().add(x);
            //box.getChildren().get(box.getChildren().size() - 1).localToParent(0, 0);
        });

        //box.getChildren().add(getLine(new Point(50, 50), new Point(500, 500)));
        box.getChildren().add(test);
        box.setAlignment(Pos.TOP_LEFT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public LineTo getLine(Point a) {
        LineTo line = new LineTo(a.x, a.y);
        /*line.setStartX(a.x);
        line.setStartY(a.y);
        line.setEndX(b.x);
        line.setEndY(b.y);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);
        //line.setLayoutX(a.x);
        //line.setLayoutY(a.y);
        //line.setTranslateX(-line.getLayoutX() + a.x);
        //line.setTranslateY(-line.getLayoutY() + a.y);
        //System.out.println(line.);*/
        return line;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
