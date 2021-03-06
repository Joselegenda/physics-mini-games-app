/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package physicsminigames;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author cstuser
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    AnchorPane rootPane;
    
    @FXML
    VBox box;
    
    @FXML
    Button game1;
    
    @FXML
    Button game2;
    
    @FXML
    Button game3;
    
    @FXML
    private void startMiniGame1(ActionEvent event) throws IOException {
        
        // Start mini game in new window
        Parent newRoot = FXMLLoader.load(getClass().getResource("FXMLMiniGame1.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Charge Cannon");
        stage.setScene(new Scene(newRoot));
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                FXMLMiniGame1Controller.getMediaPlayer().stop();
            }
        });
    }
    
    @FXML
    private void startMiniGame2(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("FXMLMiniGame2.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Projectile Shooter");
        stage.setScene(new Scene(newRoot));
        stage.show();
    }
    
    @FXML
    private void startMiniGame3(ActionEvent event) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("FXMLMiniGame3.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Mirrors of Life");
        stage.setScene(new Scene(newRoot));
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                FXMLMiniGame3Controller.getMediaPlayer().stop();
            }
        });
    }
    
    static private String fileURL(String relativePath) {
        return new File(relativePath).toURI().toString();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image background = new Image(fileURL("./assets/menu_bg.jpg"));
        Background backgroundImage = new Background(
                new BackgroundImage(background,
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT));
        
        rootPane.setBackground(backgroundImage);
    }    
    
}
