package gui;

public class VerificaInterativo implements Strategy{
	
	public boolean verificarEmail(String email) {
		
		if((email.charAt(0)=='@')||(email.charAt((email.length()-1))=='@')){
			return false;
		}
		
		for(int contador=0;contador<email.length();++contador){
			if(email.charAt(contador)=='@'){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean verificarCampo(String campo, int max, int min) {
		// TODO Auto-generated method stub
		return false;
	} 

}
