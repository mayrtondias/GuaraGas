package gui;

public class VerificaInterativo implements Strategy {

	public boolean verificarEmail(String email) {

		if ((email.charAt(0) == '@')
				|| (email.charAt((email.length() - 1)) == '@')) {
			return false;
		}

		for (int contador = 0; contador < email.length(); ++contador) {
			if (email.charAt(contador) == '@') {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean verificarCampo(String campo, int max, int min) {
		
		if ((campo.length() > max) || (campo.length() < min)) {
			return false;
		}

		for (int i = 0; i < campo.length(); i++) {
			if (Character.isDigit(campo.charAt(i)))
				return false;
		}
		return true;
	}

}
