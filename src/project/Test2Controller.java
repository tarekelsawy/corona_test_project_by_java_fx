

package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Test2Controller implements Initializable {

    TestController ob ;
    
    static int numberOfSelected = 0;
    
    @FXML
    AnchorPane pane;
    
    @FXML Text label ;
    
    @FXML
  CheckBox c1 , c2 , c3 , c4 , c5 , c6 , c7 , c8 ,c9 , c10 , c11 , c12 ,
           c13 , c14 , c15 , c16 , c17 , c18 , c19 , c20, c21 , c22 , c23 , c24;
    
    @FXML 
    public void ResultOfTest(ActionEvent e) throws Exception{

        sendCheckBoxes();
        
        if(numberOfSelected >= 6) // actuallt it will not exceed 6;
        {
            
            directUserToResult();
            
        }
        else{
            
            label.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");            
            label.setText("All questions must be answered!");
        }
    }
        @FXML
   public void BackToTest1(ActionEvent e) throws Exception{
       
            AnchorPane ap =  FXMLLoader.load(getClass().getResource("test1.fxml"));
            
            pane.getChildren().setAll(ap);
   }
   
    private float calculatePercent(){
        
        return (ob.valueOfTest1 / 120) *100 ;
    }
    
    private void directUserToResult() throws Exception{
        
        float resultOfTest = calculatePercent();
        
        if((resultOfTest >= 0) && (resultOfTest <= 35))
        {
            AnchorPane ap =  FXMLLoader.load(getClass().getResource("result.fxml"));
            
            pane.getChildren().setAll(ap); 
            
        }
        else if ((resultOfTest > 35) && (resultOfTest <=70))
        {
            AnchorPane ap =  FXMLLoader.load(getClass().getResource("result2.fxml"));
            
            pane.getChildren().setAll(ap); 
            
        }
        else
        {
            AnchorPane ap =  FXMLLoader.load(getClass().getResource("result3.fxml"));
            
            pane.getChildren().setAll(ap);            
        }
    }
   
    /////////////      handling group 1
    
    @FXML
    public void handleC1(ActionEvent e){
       
        if(c1.isSelected()){
            
            c2.setSelected(false);  c3.setSelected(false);  c4.setSelected(false);
        }
    }
     @FXML
    public void handleC2(ActionEvent e){
        
        if(c2.isSelected()){
            
            c1.setSelected(false);    c3.setSelected(false);   c4.setSelected(false);
        }
    }
     @FXML
    public void handleC3(ActionEvent e){
        
        if(c3.isSelected()){
            
            c1.setSelected(false);  c2.setSelected(false);  c4.setSelected(false);
        }
    }
     @FXML
    public void handleC4(ActionEvent e){
        
        if(c4.isSelected()){
          
            c1.setSelected(false);  c3.setSelected(false);  c2.setSelected(false);
        } 
    }
    /////////////      handling group 2
    
     @FXML
    public void handleC5(ActionEvent e){
        
        if(c5.isSelected()){
          
            c6.setSelected(false);  c7.setSelected(false);  c8.setSelected(false);
        } 
    }
         @FXML
    public void handleC6(ActionEvent e){
        
        if(c6.isSelected()){
          
            c5.setSelected(false);  c7.setSelected(false);  c8.setSelected(false);
        } 
    }
         @FXML
    public void handleC7(ActionEvent e){
        
        if(c7.isSelected()){
          
            c5.setSelected(false);  c6.setSelected(false);  c8.setSelected(false);
        } 
    }
         @FXML
    public void handleC8(ActionEvent e){
        
        if(c8.isSelected()){
          
            c5.setSelected(false);  c6.setSelected(false);  c7.setSelected(false);
        } 
    }
    
    /////////////      handling group 3
    
    @FXML
    public void handleC9(ActionEvent e){
        
        if(c9.isSelected()){
          
            c10.setSelected(false);  c11.setSelected(false);  c12.setSelected(false);
        } 
    }
             @FXML
    public void handleC10(ActionEvent e){
        
        if(c10.isSelected()){
          
            c9.setSelected(false);  c11.setSelected(false);  c12.setSelected(false);
        } 
    }
             @FXML
    public void handleC11(ActionEvent e){
        
        if(c11.isSelected()){
          
            c9.setSelected(false);  c10.setSelected(false);  c12.setSelected(false);
        } 
    }
             @FXML
    public void handleC12(ActionEvent e){
        
        if(c12.isSelected()){
          
            c9.setSelected(false);  c10.setSelected(false);  c11.setSelected(false);
        } 
    }
    
    /////////////      handling group 4
    
             @FXML
    public void handleC13(ActionEvent e){
        
        if(c13.isSelected()){
          
            c14.setSelected(false);  c15.setSelected(false);  c16.setSelected(false);
        } 
    }
    
             @FXML
    public void handleC14(ActionEvent e){
        
        if(c14.isSelected()){
          
            c13.setSelected(false);  c15.setSelected(false);  c16.setSelected(false);
        } 
    }
             @FXML
    public void handleC15(ActionEvent e){
        
        if(c15.isSelected()){
          
            c13.setSelected(false);  c14.setSelected(false);  c16.setSelected(false);
        } 
    }
             @FXML
    public void handleC16(ActionEvent e){
        
        if(c16.isSelected()){
          
            c13.setSelected(false);  c14.setSelected(false);  c15.setSelected(false);
        } 
    }
    
    /////////////      handling group 5
    
             @FXML
    public void handleC17(ActionEvent e){
        
        if(c17.isSelected()){
          
            c18.setSelected(false);  c19.setSelected(false);  c20.setSelected(false);
        } 
    }
    
             @FXML
    public void handleC18(ActionEvent e){
        
        if(c18.isSelected()){
          
            c17.setSelected(false);  c19.setSelected(false);  c20.setSelected(false);
        } 
    }
    
             @FXML
    public void handleC19(ActionEvent e){
        
        if(c19.isSelected()){
          
            c17.setSelected(false);  c18.setSelected(false);  c20.setSelected(false);
        } 
    }
    
             @FXML
    public void handleC20(ActionEvent e){
        
        if(c20.isSelected()){
          
            c17.setSelected(false);  c18.setSelected(false);  c19.setSelected(false);
        } 
    }
    
    /////////////      handling group 6
             @FXML
    public void handleC21(ActionEvent e){
        
        if(c21.isSelected()){
          
            c22.setSelected(false);  c23.setSelected(false);  c24.setSelected(false);
        } 
    }
    
    
             @FXML
    public void handleC22(ActionEvent e){
        
        if(c22.isSelected()){
          
            c21.setSelected(false);  c23.setSelected(false);  c24.setSelected(false);
        } 
    }
    
             @FXML
    public void handleC23(ActionEvent e){
        
        if(c23.isSelected()){
          
            c21.setSelected(false);  c22.setSelected(false);  c24.setSelected(false);
        } 
    }
    
             @FXML
    public void handleC24(ActionEvent e){
        
        if(c24.isSelected()){
          
            c21.setSelected(false);  c22.setSelected(false);  c23.setSelected(false);
        } 
    }
    
    public void calculateValue(CheckBox c){
        
        if(c.isSelected())
        {
             numberOfSelected++;
         
             switch(c.getText()){
             
                case "لا" :
 
                     ob.valueOfTest1 += 1 ;   break ;
                     
                case "قليلا" :
                     
                    ob.valueOfTest1 += 3.5;   break ;
                
                case "احيانا" :
                           
                    ob.valueOfTest1 += 6 ;    break ;
                
                    default:
                        
                        ob.valueOfTest1 += 8.5 ;
             
             }
        }
    }
    
    public void sendCheckBoxes(){
        
     calculateValue(c1); calculateValue(c2); calculateValue(c3); calculateValue(c4);
     
     calculateValue(c5); calculateValue(c6); calculateValue(c7); calculateValue(c8);
     
     calculateValue(c9); calculateValue(c10); calculateValue(c11); calculateValue(c12);
     
     calculateValue(c13); calculateValue(c14); calculateValue(c15); calculateValue(c16);
     
     calculateValue(c17); calculateValue(c18); calculateValue(c19); calculateValue(c20);
     
     calculateValue(c21); calculateValue(c22); calculateValue(c23); calculateValue(c24);
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // reset your label here !!
        
        ob = new TestController();   // to access the value of the results of test1
        
        label.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");  // choose same background color;
        label.setText("");                                                      
        
    }
    
}


















/*
package project;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Test2Controller implements Initializable {

    @FXML
    AnchorPane test2pane;
    
    public void loadtest(ActionEvent ae) throws IOException
    {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("test.fxml"));
        test2pane.getChildren().setAll(ap);
    }
    
    public void loadresult(ActionEvent ae)throws IOException
    {
        ///three test cases for result
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
*/