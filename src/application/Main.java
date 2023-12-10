package application;

import constant.team.Team;
import entity.agent.Jett;
import entity.base.Agent;
import constant.map.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public static Map map = new Map();
    public static int roundCount = 0;
    public static boolean isSpikedefuse = false;
    public static List<Agent> defenderAgentList;
    public static List<Agent> attackerAgentList;


    public static void main(String[] args) {

//        select agent
//        AgentSelection.makeSelection();

//        run gameCore
//        GameCore.playGame();



    }

    @Override
    public void start(Stage stage) throws Exception {

            StackPane root = new StackPane();
            root.setPadding(new Insets(15));

            Jett jett = new Jett("Jett", Team.DEFENDER);

            /* Not using class loader */
            //ImageView imageView = new ImageView(new Image("file:res/images/homestay.jpg"));

            /* Using class loader */
            String image_path = ClassLoader.getSystemResource("images/homestay.jpg").toString();
            ImageView imageView = new ImageView(new Image(image_path));

            imageView.setPreserveRatio(true);
            imageView.setFitWidth(1000);

            root.getChildren().add(imageView);

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Image Loader");
            stage.show();
    }
}