package project;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class FXMLDocumentController implements Initializable {

    Project ob;
    @FXML
    AnchorPane signUpPane;
    
    @FXML
    ComboBox govs;

    @FXML
    ComboBox gen;
    String governorate , gender;
    @FXML
    TextField nameTextField, ssnTextField, emailTextField, ageTextField;

    @FXML
    Text nameLabel, ssnLabel, emailLabel, ageLabel, govsLabel, genLabel;
    
    @FXML
    public void signupButton(ActionEvent e) {

        boolean checkName=checkNameTextField(nameTextField.getText());
        System.out.print("true\n");
        boolean checkSsn=checkSsnTextField(ssnTextField.getText());
        System.out.print("true\n");
        boolean checkEmail=checkEmailTextField(emailTextField.getText());
        System.out.print("true\n");
        boolean checkAge=checkAgeTextField(ageTextField.getText());
        System.out.print("true\n");
        if(checkName==true&&checkSsn==true&&checkEmail==true&&checkAge==true)
        {
            connect();            
        }

    }
    /*connect with database*/
    public void connect() 
    {
        
        Connection conn =null;
        Statement stmt = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/patient_management","root","");
            stmt = conn.createStatement();
            System.out.println(Integer.parseInt(ssnTextField.getText())+" "+nameTextField.getText()+" "+Integer.parseInt(ageTextField.getText())
            +" "+emailTextField.getText()+" "+gender+" "+governorate);
            stmt.executeUpdate("insert into users values("+Integer.parseInt(ssnTextField.getText())+
                    " , '"+nameTextField.getText()+"' , "+Integer.parseInt(ageTextField.getText())+
                    " , '"+emailTextField.getText()+
                    "' , '"+gender+"' , '"+governorate+"')");
            
            keepLink();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.print("connect\n");
        
    }
    /*link test.fxml if all textfield true */
    public void keepLink()
    {
        AnchorPane p1=null;
            try {
                Project.ssn = Integer.parseInt(ssnTextField.getText());
                p1 = FXMLLoader.load(getClass().getResource("test.fxml"));
                signUpPane.getChildren().setAll(p1);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.print("keepLink\n");
    }

    /*function for testing  texfield input from user **/
    public boolean checkNameTextField(String name ) {
         if(name.length()==0)
        {
            nameLabel.setText("age required!");
            nameLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
            return false;
        }
         System.out.print("checkNameTextField\n");
         return true;
         
    }

    /*function for test ssn text field input from user*/
    public boolean checkSsnTextField(String ssn) {
         if(ssn.length()==0)
        {
            ssnLabel.setText("age required!");
            ssnLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
            return false;
        }
         System.out.print("checkSsnTextField\n");
        return true ;
    }

    /*function for test Email text field input from user*/
    public boolean checkEmailTextField(String email) {
        boolean at=false , dot = false;
        for (int i = 0; i < emailTextField.getText().length(); ++i) {
            if(email.charAt(i)=='@')
                at=true;
            if(email.charAt(i)=='.')
                dot=true; 
       }
       emailLabel.setText("email ");
       if(at==false)
       {
           emailLabel.setText(emailLabel.getText()+" missed @");
           emailLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
       }
       if(dot==false)
       {
           emailLabel.setText(emailLabel.getText()+" missed .");
           emailLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
       }
       /*if(dot==true&&at==true)
       {
           emailLabel.setText(emailLabel.getText()+" correct");
           emailLabel.setStyle("-fx-text-fill:green;-fx-font-size:12px;-fx-background-color:#ffe9e3;");
       }*/
       System.out.print("checkEmailTextField\n");
       return (dot==true&&at==true);
    }

    /*function for test age text field input from user*/
    public boolean checkAgeTextField(String age) {
        if(age.length()==0)
        {
            ageLabel.setText("age required!");
            ageLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
            return false;
        }
        if(age.length()>2)
        {
            ageLabel.setText("invalid age!");
            ageLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
            return false;
        }
        boolean found=true;
        for(int i=0;i<age.length();++i)
        {
            if(age.charAt(i)<'0'||age.charAt(i)>'9')
            {
                ageLabel.setText("character invalid in age field!");
                ageLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
                return false;
            }
        }
        System.out.print("checkAgeTextField\n");
        return true;
    }
    public void govsAction(ActionEvent e)
    {
        governorate = govs.getValue().toString();
        System.out.print("checkgovsTextField\n");
    }
    public void genderAction(ActionEvent e)
    {
        gender = gen.getValue().toString();
        System.out.print("checkGenderTextField\n");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> list = FXCollections.observableArrayList("Cairo", "Giza", "Alexandria", "Marsa Matrouh", "Kafr ELshikh", "Fayoum", "Dakahlia", "Albahr Elahmar", "Asyut", "Minya", "Ismailia", "ELsharagiuh", "Janub Sayna", "Shamal Sayna", "Suez", "Algharbiuh", "Monufia", "Elbuhayrah", "Bani Sweif", "Qalyubia", "Sohag", "Qena", "Alwada Aljadid", "Aswan", "Alaqsir", "Bur Saeid", "Damiat");
        govs.setItems(list);
        ObservableList<String> list1 = FXCollections.observableArrayList("Male", "Female");
        gen.setItems(list1);
        nameLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        ssnLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        ageLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        emailLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        govsLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        genLabel.setStyle("-fx-font-size:12px;-fx-fill:red;-fx-background-color:#ffe9e3;");
        
    }

}

/*
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    ComboBox govs;
    @FXML
    ComboBox gen;
    @FXML
    AnchorPane fxmldocumentpane;
    
    public void loadtest(ActionEvent ae) throws IOException
    {
        AnchorPane ap = FXMLLoader.load(getClass().getResource("test.fxml"));
        fxmldocumentpane.getChildren().setAll(ap);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String>list=FXCollections.observableArrayList("Cairo","Giza","Alexandria","Marsa Matrouh","Kafr ELshikh","Fayoum","Dakahlia","Albahr Elahmar","Asyut","Minya","Ismailia","ELsharagiuh","Janub Sayna","Shamal Sayna","Suez","Algharbiuh","Monufia","Elbuhayrah","Bani Sweif","Qalyubia","Sohag","Qena","Alwada Aljadid","Aswan","Alaqsir","Bur Saeid","Damiat");
         govs.setItems(list);
        ObservableList<String>list1=FXCollections.observableArrayList("Male","Female");
        gen.setItems(list1);
    }    
    
}
 */
/**
 @FXML ComboBox govs;
    
    @FXML ComboBox gen;
    
    @FXML TextField name , age , email , ssn;
    
    @FXML Label nameLabel , ssnLabel , ageLabel ,emailLabel , govsLabel , genLabel ;
        
    Project ob;
       
   @FXML
    public void signupButton(ActionEvent e){
  
        handleCheckBoxes();
       
        if((nameLabel.getText().equals("Correct")) && (ssnLabel.getText().equals("Correct")) && 
                (emailLabel.getText().equals("Correct")) && (ageLabel.getText().equals("Correct")) &&
                (govsLabel.getText().equals("Correct")) && (genLabel.getText().equals("Correct")))
            
            insertUserIntoSystem();
         
            // resetNodes();
        
    }
    //////////////////////////// handling values while user typing
    @FXML
    public void nameTyping(KeyEvent e){
        
        nameLabel.setText(checkName(name.getText()));
       
        labelPainting(nameLabel);
    }
    @FXML
    public void ssnTyping(KeyEvent e){
        
        ssnLabel.setText(checkSsn(ssn.getText()));
        
        labelPainting(ssnLabel);
    }
    @FXML
    public void emailTyping(KeyEvent e){
    
        emailLabel.setText(checkEmail(email.getText()));
        
        labelPainting(emailLabel);
    
    }
    @FXML
    public void ageTyping(KeyEvent e){
    
        ageLabel.setText(checkAge(age.getText()));
        
        labelPainting(ageLabel);
    
    }
    
    public void labelPainting(Label l){
        
        if(l.getText().equals("Correct"))
        
            l.setStyle("-fx-text-color: green; -fx-font-size: 15px; -fx-font-family:TimesNewRoman;");
        
        else
            
            l.setStyle("-fx-text-color: red; -fx-font-size: 15px; -fx-font-family:TimesNewRoman;");
       
    }
    ///////////////////////////////////////////////////// end of painting labels
    
   
    ///////////////////////////////////////////// checking values of entered texts;
    
    public String checkName(String name){
    
         if(name.equals(""))
             
             return ("Empty!");
         
         if(Character.isDigit(name.charAt(0)))
             
             return ("Begin by digit!");
         
         return ("Correct");
                     
    }
    public String checkSsn(String ssn){
        
        if(ssn.length() < 10)
            
            return ("Less Than 10!");
        else
        {
          for(int i=0 ; i <ssn.length() ; i++){
              
              if(Character.isLetter(ssn.charAt(i)))
                  
                  return ("Include Letters!");
          }    
            
        }
        return ("Correct");
    }
    
    public String checkEmail(String mail){
        
        boolean atFlag = false , dotFlag = false ;
        
        for(int i = 0 ; i < mail.length() ; i++)
        {
            if(mail.charAt(i) == '@')
                
                atFlag = true;
            
            if(mail.charAt(i) == '.')
                
                dotFlag = true;
            
        }
        
        if(atFlag && dotFlag)
            
            return ("Correct");
        else
            
            return ("@ or . is missed");
        
    }
    public String checkAge(String age){
        
        if(age.equals(""))
        
            return ("age is missed");
        else
        {
        int num = Integer.parseInt(age);
        
        if((num < 0) || (num > 120))
            
          return ("incorrect value of age");
        }
        return ("Correct");
    }
    //////////////////////////////////////////////////////////end of ckecking values of texts;
   
    //////////  handle the choice state of the combo boxes ;
    
    public void handleCheckBoxes(){
        
        boolean govsEmpty = (govs.getSelectionModel().isEmpty());
        boolean genEmpty = (gen.getSelectionModel().isEmpty());
        
        String s = ((govsEmpty) ? "Choose a Governorte!" : "Correct");
        
        govsLabel.setText(s);
        
        labelPainting(govsLabel);
 
        s = ((genEmpty) ? "Choose a Gender!" : "Correct");
        
        genLabel.setText(s);
        
        labelPainting(genLabel);    
    }
    
    public void insertUserIntoSystem(){
        
        try{
        
            String governorate = govs.getValue().toString();
            
            String gender = govs.getValue().toString();
            
            ob.startDataBaseConnection();
        
            ob.stmt.executeUpdate("insert into users values (" + Integer.parseInt(ssn.getText()) + " , '" + name.getText() + "' ," +
                    + Integer.parseInt(age.getText()) + ", '" + email.getText() + "' , '" + gender + "' , '" + governorate +"'" );
        
            ob.closeDataBaseConnection();
            
            ob.ssn = Integer.parseInt(ssn.getText()); // letter usage;
        
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void resetNodes(){
        
        name.setText("");      nameLabel.setText("");
        
        age.setText("");       ageLabel.setText("");
        
        email.setText("");     emailLabel.setText("");   
        
       ssn.setText("");        ssnLabel.setText("");
       
       govs.setValue(null);      gen.setValue(null);
       
       govsLabel.setText("");  genLabel.setText("");
    }
 
 **/
