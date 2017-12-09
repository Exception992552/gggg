package app.classes;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class tasklist {
    @FXML
    private TextArea b;


    public void initialize(){
        try {
            String line;

            Process p = Runtime.getRuntime().exec("C:\\26\\src\\app\\bat\\tasklist.bat");
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
