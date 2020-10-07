package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	// Dependencia para Department
	private Department entity;

	// Atributos -> Elementos no SceneBuilder
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

	// Metodos

	public void setDepartment(Department entity) { // Instancia do Department
		this.entity = entity;
	}

	@FXML
	public void onBtSaveAction() { // Tratar os eventos dos botões
	}

	@FXML
	public void onBtCancelAction() { // Tratar os eventos dos botões
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	private void initializeNodes() { // Restrições Id, Name
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 12);
	}

	public void updateFormData() { // Responsavel por popular cxs do formulario atraves do Department entity
		if (entity == null) { //Prog defensiva
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId())); // Usa valueOf para conversão de Integer para String
		txtName.setText(entity.getName());
	}

}
