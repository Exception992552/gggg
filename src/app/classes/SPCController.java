package app.classes;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SPCController{

    @FXML
    private Button getOSButton;
    @FXML
    private Button DevConButton;
    @FXML
    private Button tasklistbutton;

    private  MainController mainController;


    @FXML
    public void loadgetOS(){
        mainController.goTogetOS();
    }

    @FXML
    public void loadDevCon(){
        mainController.goToDevCon();
    }

    @FXML
    public void loadtasklist(){
        mainController.goTotasklist();
    }


    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }

    public void setMainController(MainController controller){
        this.mainController = controller;
    }
}
