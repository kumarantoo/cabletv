package com.cabletv.app.Main;

import com.cabletv.app.models.TestSpring;
import com.cabletv.app.utils.PropertyLoader;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
Kumaran
CopyRight to KumaranTech & Traders
Chennai
 */
public class MainApp extends Application {

    /*
    Main Scean From starting of Application
     */
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.getIcons().add(new Image("/images/dish.jpg"));
        stage.setTitle(PropertyLoader.readTamil("companyname")+"-"+PropertyLoader.readTamil("companyaddress"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         ApplicationContext context = new ClassPathXmlApplicationContext("/config/cabletv-springconfig.xml");
	  
        TestSpring te  = (TestSpring)context.getBean("testSpr");
        System.out.println("com.cable"+te.getTestSpring());
        launch(args);
    }

    
    
    
}
