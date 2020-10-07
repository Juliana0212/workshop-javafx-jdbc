package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	
	//Metodos 

	//Restri��o para aceitar somente numero inteiro
	public static void setTextFieldInteger(TextField txt) { 
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}
	
	//Restri��o para numero de caracteres 
	public static void setTextFieldMaxLength(TextField txt, int max) { 
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	//Restri��o para numeros reais
	public static void setTextFieldDouble(TextField txt) { 
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldValue);
			}
		});
	}
}