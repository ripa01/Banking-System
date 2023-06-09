package ishrat;

import java.io.FileNotFoundException;

import java.io.IOException;

import application.Main;
import banking.InSufficientBalanceException;
import banking.InvalidAccountException;
import banking.MaxWithdawException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class transacionsController {
	Main main = new Main(); // Added by azmee
	 @FXML
	 TextField acNumTf;
	 @FXML
	 TextField amtTf;
	 @FXML
	 TextField fromAcTf;
	 @FXML
	 TextField toAcTf;
	 @FXML
	 Label mylabel;
	 
	 
	public void withdraw() throws InSufficientBalanceException, MaxWithdawException, FileNotFoundException, IOException, InvalidAccountException {
		 String accNum = acNumTf.getText();
		 double amt = Double.parseDouble(amtTf.getText());
		    	  try {
		      Main.bank.withdraw(accNum, amt);
			  Main.bank.saveData();
			  mylabel.setText("Amount: "+amt+" to Account No: "+accNum+"\n\tWithdraw Money Successfully!");
		             	
		 }catch (InSufficientBalanceException e) {
			mylabel.setText("SORRY!NOT ENOUGH BALANCE!!");
			e.printStackTrace();
		}
		 catch (MaxWithdawException e) {
				mylabel.setText("CAN'T WITHDRAW THIS AMMOUNT!!");
				e.printStackTrace();
			}
		 catch (FileNotFoundException e) {
				mylabel.setText("ACCOUNT "+accNum+" NOT FOUND");
				e.printStackTrace();
			}
		  catch (InvalidAccountException e) {
				mylabel.setText("SORRY!!ACCOUNT "+accNum+" NOT FOUND!!");
				e.printStackTrace();
			}
		catch(IOException e) {
				mylabel.setText("INVALID INPUT!! TRY AGAIN!!");
				e.printStackTrace();
			}
	 }
	 
	 public void deposit() throws FileNotFoundException, IOException, InvalidAccountException {
		 String accNum = acNumTf.getText();
		 double amt = Double.parseDouble(amtTf.getText());
		 try {
			Main.bank.deposit(accNum, amt);
			Main.bank.saveData();
			mylabel.setText("Amount: "+amt+" to Account No: "+accNum+"\n\tDeposited Money Successfully!");
			
		}
		 catch (FileNotFoundException e) {
				mylabel.setText("ACCOUNT "+accNum+" NOT FOUND!!");
				e.printStackTrace();
			}
		 catch (InvalidAccountException e) {
				mylabel.setText("SORRY!!ACCOUNT "+accNum+" NOT FOUND!!");
				e.printStackTrace();
			}
		catch(IOException e) {
				mylabel.setText("INVALID INPUT!! TRY AGAIN!!");
				e.printStackTrace();
			}
	 }
	 
	 public void home(ActionEvent event) throws IOException{
			main.changeScene("../azmee/Main.fxml");
    }
	 public void back(ActionEvent event) throws IOException{
			main.changeScene("../azmee/Employee.fxml");
	}
	 public void transfer() throws InSufficientBalanceException, MaxWithdawException, FileNotFoundException, IOException, InvalidAccountException {
		 String fromAccNum = fromAcTf.getText();
		 String toAccNum = toAcTf.getText();
		 double amt = Double.parseDouble(amtTf.getText());
	 	try {
			Main.bank.transfer(fromAccNum,toAccNum,amt);
			Main.bank.saveData();
			mylabel.setText("Amount:"+amt+" Transfer from Account No:"+fromAccNum+" to Account No:"+toAccNum+"\n\tTransfered Successfully!");
			
		} catch (InSufficientBalanceException e) {
			mylabel.setText("SORRY!!NOT ENOUGH BALANCE!!");
			e.printStackTrace();
		}
		 catch (MaxWithdawException e) {
				mylabel.setText("CAN'T TRANSFER THIS AMMOUNT!!");
				e.printStackTrace();
			}
		 catch (FileNotFoundException e) {
				mylabel.setText("SORRY!!ACCOUNT NOT FOUND");
				e.printStackTrace();
			}
	 	 catch (InvalidAccountException e) {
				mylabel.setText("SORRY!!ACCOUNT NOT FOUND");
				e.printStackTrace();
			}
	 	
		catch(IOException e) {
				mylabel.setText("INVALID INPUT!! TRY AGAIN!!");
				e.printStackTrace();
			}
		 
	 }
}
