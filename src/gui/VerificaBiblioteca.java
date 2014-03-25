package gui;

public class VerificaBiblioteca implements Strategy {

	public boolean verificarEmail(String email) {

		if (email.indexOf("@") < 0)
			return false;
		if ((email.charAt(0) == '@')
				|| (email.charAt(email.length() - 1) == '@'))
			return false;
		return true;
	}

	public boolean verificarCampo(String campo, int max, int min) {
		System.err.println("c");
		if ((campo.length() > max) || (campo.length() < min)) {
			return false;
		}
		
		for (int i = 0; i < campo.length(); i++) {
			if (Character.isDigit(campo.charAt(i))){
				return false;
			}
				
		}
		return true;
	}

}
