package com.cabletv.app.controllers;

import com.cabletv.app.utils.PropertyLoader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import java.util.logging.*;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import java.io.IOException;



public class LoginController implements Initializable {
    
  private Scene scene;
  Stage prevStage;

 /* public LoginController(Scene scene) {
    this.scene = scene;
  }*/
   // private static final Logger log = ge
    @FXML
    private Label labelMessage;
    
  @FXML private TextField userName;
  @FXML private TextField password;
  @FXML private Button loginButton;
  
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
        String sessionID = authorize();
        System.out.println("You clicked me!"+sessionID);
      
        
         if (sessionID != null) {
          
          showAdminView(sessionID);
          
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private String authorize() throws Exception {
        
        String sessId = null;
        
        if("admin".equals(userName.getText()) && "admin".equals(password.getText())) {
            
          sessId = generateSessionID();
        } else {
            
             //labelMessage.setText(PropertyLoader.readEnglish("invalidLogin"));
       labelMessage.setText(PropertyLoader.readTamil("invalidlogin"));
        
        
        }
        
    /*return 
      "admin".equals(userName.getText()) && "admin".equals(password.getText()) 
            ? generateSessionID() 
            : null;*/
    
    return sessId;
  }
    
    
    private static int sessionID = 0;

  private String generateSessionID() {
    sessionID++;
    return "xyzzy - session " + sessionID;
  }
  
  
  private void showAdminView(String sessionID) {
   
     /* FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/fxml/AdminMenu.fxml")
      );
     
      scene.setRoot((Parent) loader.load());
      AdminMenuController controller = 
        loader.<AdminMenuController>getController();
      //controller.initSessionID(this, sessionID);*/
     
    /*  FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/fxml/AdminMenu.fxml")
      );
      scene.setRoot((Parent) loader.load());
      AdminMenuController controller = 
        loader.<AdminMenuController>getController();
      controller.initSessionID(sessionID);
      
     */
    
    Stage stage; 
     Parent root;
      try {
          FXMLLoader loader = new FXMLLoader();
    // if(event.getSource()==btn1){
        //get reference to the button's stage         
        stage=(Stage) loginButton.getScene().getWindow();
        //load up OTHER FXML document
  root = FXMLLoader.load(getClass().getResource("/fxml/AdminMenu.fxml"));
  loader.setResources(ResourceBundle.getBundle("res_bundles/cabletv_generic_TAMIL"));
    //  }
    // else{
      // stage=(Stage) loginButton.getScene().getWindow();
//  root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    
     //create a new scene with root and set the stage
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    } catch (IOException ex) {
      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
 
   
   
   
}
