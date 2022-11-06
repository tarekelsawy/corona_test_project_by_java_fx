
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ResulteController implements Initializable {

    @FXML  AnchorPane pane ;
    
    @FXML
    public void Restart(ActionEvent e) throws Exception{
       
           AnchorPane ap =  FXMLLoader.load(getClass().getResource("choose.fxml"));
            
            pane.getChildren().setAll(ap);
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}





















/*
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class ResulteController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
*/