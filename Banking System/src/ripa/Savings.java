package ripa;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Savings {
	public static Main main= new Main();
	@FXML
	TextField Name;
	@FXML
	TextField Nid;
	@FXML
	TextField MaxLim;
	@FXML
	TextField Balance;
	@FXML
	Label mylabel;
	
	public void Submit(ActionEvent event) throws IOException {
		String name = Name.getText();
		String nid = Nid.getText();
		double Max = Double.parseDouble(MaxLim.getText());
		double balance = Double.parseDouble(Balance.getText());
		String AccNum = Main.bank.addAccount(name, nid, balance, Max);
		Main.bank.saveData();
		mylabel.setText("Account Created Successfully.\nYour Account Number is: "+AccNum);
	}
	
	public void Home(ActionEvent event) throws IOException {
		main.changeScene("../azmee/Main.fxml");
	}
	
	public void Back(ActionEvent event) throws IOException {
		main.changeScene("../azmee/CreateAccount.fxml");
	}
	 public void clear(ActionEvent event) {
	    	Name.clear();
			Nid.clear();
			Balance.clear();
			MaxLim.clear();
			mylabel.setText(null);
	    }
}
