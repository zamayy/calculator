package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class HelloController {

    @FXML
    private Text output;
    private long num1 = 0;
    private long num2 = 0;
    private boolean start = true;
    private String operator = "";
    private Model model = new Model();
//    private boolean gotoexit;

    @FXML
    private void processnum(ActionEvent event){
        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText()+value);

    }

    @FXML
    private void processoperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!"=".equals(value)){
            if(!operator.isEmpty()) return;
            operator = value;
            num1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else{
            if(operator.isEmpty()) return;
            output.setText(String.valueOf(model.shitalka(num1,Long.parseLong(output.getText()),operator)));
            operator = "";
            start = true;
        }
    }
//    @FXML
//    private void exitapp(ActionEvent event){
//        gotoexit = true;
//    }
}
