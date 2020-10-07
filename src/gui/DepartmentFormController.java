package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	// Dependencia para Department
	
	private Department entity;

	private DepartmentService service;
	
	//Listas
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>(); //Permiti que outros objetos se inscrevam na lista e receberem o evento 

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

	// Métodos

	public void setDepartment(Department entity) { // Instanciação do Department
		this.entity = entity;
	}

	public void setDepartmentService(DepartmentService service) { // Instanciação do DepartmentService
		this.service = service;
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) { // Método para adicionar na lista
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) { // Tratar os eventos dos botões
		if (entity == null) {
			throw new IllegalStateException ("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException ("Service was null");
		}
		
		try {
			entity = getFormData();
			service.saveOrUpdate(entity); // Salver no banco de dados
			notifyDataChangeListener(); //Notificar Listeners
			Utils.currentStage(event).close();
		}
		catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void notifyDataChangeListener() { //Método para notficar os Listeners
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();			
		}
		
	}

	private Department getFormData() { //Responsavel por "pegar" os dados do formulario e "guardar" no obj
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) { // Tratar os eventos dos botões
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	private void initializeNodes() { // Restrições Id, Name
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 12);
	}

	public void updateFormData() { // Responsavel por popular cxs do formulario atraves do Department entity
		if (entity == null) { // Prog defensiva
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId())); // Usa valueOf para conversão de Integer para String
		txtName.setText(entity.getName());
	}

}
