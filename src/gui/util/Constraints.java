package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	
	//Metodos 

	//Restrição para aceitar somente numero inteiro
	public static void setTextFieldInteger(TextField txt) { 
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}
	
	//Restrição para numero de caracteres 
	public static void setTextFieldMaxLength(TextField txt, int max) { 
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	//Restrição para numeros reais
	public static void setTextFieldDouble(TextField txt) { 
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldValue);
			}
		});
	}
}