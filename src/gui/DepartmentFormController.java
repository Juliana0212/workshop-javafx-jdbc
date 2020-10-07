package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

	//Atributos -> Elementos no SceneBuilder
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	//Metodos
	
	@FXML
	public void onBtSaveAction() {	//Tratar os eventos dos botões	
	}

	@FXML
	public void onBtCancelAction() { //Tratar os eventos dos botões	
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {		
	}
	
	//Restrições
	 private void initializeNodes() {
		 Constraints.setTextFieldInteger(txtId);
		 Constraints.setTextFieldMaxLength(txtName, 12);
	 }

}
