package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	public void onMenuItemSellerAction() {

	}

	@FXML
	public void onMenuItemDepartmentAction() {
		//Fun��o como parametro -> express�o lambda
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();			
		});
	}

	@FXML
	public void onMenuItemAboutAction() {
		//Fun��o como parametro -> express�o lambda
		loadView("/gui/About.fxml", x -> {});

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

	//Metodo generico para loadView usando Consumer
	private synchronized <T> void loadView(String absoluteName, Consumer <T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load(); // Nova janela
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear(); // Limpando children do mainVbox -> MainView
			//Adicionando na mainView os elementos de About
			mainVBox.getChildren().add(mainMenu); 
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			//Executa a a��o
			T controller = loader.getController();
			initializingAction.accept(controller);		
					
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	

}
