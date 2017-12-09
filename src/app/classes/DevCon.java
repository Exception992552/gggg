package app.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by momot on 09.12.2016.
 */
public class DevCon {
    @FXML
    private TextArea b;


    public void initialize(){
        try {
            String line;

            Process p = Runtime.getRuntime().exec("C:\\26\\src\\app\\bat\\DevCon.bat");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                b.setText(b.getText()+line+ "\n");
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
