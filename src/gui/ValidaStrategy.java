package gui;

public class ValidaStrategy {
	
	private static boolean OP = true;
	private Strategy estrategia;
	
	public ValidaStrategy(){
		definirStrategy();
	}
	
	//metodo para selecionar qual estrategia devera ser 
	//usada a cada chamada ele deve mudar de estrategia
	public void definirStrategy(){
		if(ValidaStrategy.OP==true){
			estrategia = new VerificaBiblioteca();
			ValidaStrategy.OP=false;
		}else{
			estrategia = new VerificaInterativo();
			ValidaStrategy.OP=true;
		}
	}
	
	public boolean verificarCampo(String campo, int max, int min){
		return estrategia.verificarCampo(campo, max, min);
	}
	
	public boolean verificarEmail(String email){
		return estrategia.verificarEmail(email);
	}

}
