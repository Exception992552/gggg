package app.classes;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane pane;

    @FXML
    private JFXHamburger hamburger;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/SPC.fxml"));
            VBox box = (VBox) loader.load();
            drawer.setSidePane(box);
            SPCController controller = loader.getController();
            controller.setMainController(this);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();

            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });
    }

    public void goTogetOS(){
        try {
            pane.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("../layouts/getOS.fxml")));
        } catch (Exception e){}
    }

    public void goToDevCon(){
        try {
            pane.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("../layouts/DevCon.fxml")));
        } catch (Exception e){}
    }

    public void goTotasklist(){
        try {
            pane.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("../layouts/tasklist.fxml")));
        } catch (Exception e){}
    }

}
