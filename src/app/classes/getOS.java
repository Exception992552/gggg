package app.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getOS {
    @FXML
    private Label nameOSL;

    @FXML
    private Label installL;

    @FXML
    private Label uptimeL;

    public void initialize(){
        try {
            String line;
            String lined;
            String lineb;
            Process p = Runtime.getRuntime().exec("C:\\26\\src\\app\\bat\\getOS.bat");
            Process d = Runtime.getRuntime().exec("C:\\26\\src\\app\\bat\\install.bat");
            Process b = Runtime.getRuntime().exec("C:\\26\\src\\app\\bat\\boot.bat");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader inputd =
                    new BufferedReader(new InputStreamReader(d.getInputStream()));
            BufferedReader inputb =
                    new BufferedReader(new InputStreamReader(b.getInputStream()));
            while ((line = input.readLine()) != null) {
                nameOSL.setText(line);
                System.out.println(line);
            }
            while ((lined = inputd.readLine()) != null) {
                installL.setText(lined);
                System.out.println(lined);
            }
            while ((lineb = inputb.readLine()) != null) {
                uptimeL.setText(lineb);
                System.out.println(lineb);
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}

