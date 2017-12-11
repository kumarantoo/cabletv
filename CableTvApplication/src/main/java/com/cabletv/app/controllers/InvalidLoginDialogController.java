package com.cabletv.app.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;
/**
 * FXML Controller class
 *
 * @author Kumaran
 */
public class InvalidLoginDialogController implements Initializable {

     @FXML
    private Label messageLabel ;
    private final String message ;
    
    @FXML private Button closeButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    public InvalidLoginDialogController(String message) {
        this.message = message ;
    }
    
    public void initialize() {
        messageLabel.setText(message);
    }
    
    public void close() {
        messageLabel.getScene().getWindow().hide();
    }
    
   

@FXML
private void closeButtonAction(){
    // get a handle to the stage
    Stage stage = (Stage) closeButton.getScene().getWindow();
    // do what you have to do
    stage.close();
}

}