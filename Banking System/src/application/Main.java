package application;   
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import banking.Bank;
import banking.InvalidAccountException;

public class Main extends Application{
	public static Stage stage;
	public static Bank bank = new Bank("ARIOJ BANK LIMITED");
    @Override  
    public void start(Stage primaryStage){  
        try {
        	stage = primaryStage;
	        AnchorPane root = FXMLLoader.load(getClass().getResource("../azmee/Main.fxml"));
	        Scene scene=new Scene(root,600,400);      
	        primaryStage.setTitle("ARIOJ BANK LIMITED");  
	        primaryStage.setScene(scene);  
	        primaryStage.show();
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void changeScene(String fxml) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxml)); 
        stage.getScene().setRoot(root);
	}
    
  
    public static void main (String[] args) throws IOException, InvalidAccountException, ClassNotFoundException  
    {  
       
        	bank.loadData();
        
        System.out.println(bank.getBankName());
        System.out.println(bank.getAccounts());
        
    	launch(args);  
    }
}