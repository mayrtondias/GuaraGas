package gui;

import javax.swing.JOptionPane;

public class GuaraGasApp {

	public static void main(String[] args) {
		GuiFactory g;
		String aux;
		int op = 0, op2 = 0;
		boolean teste = false;
		do {
			try {

				aux = JOptionPane.showInputDialog("Escolha entre:\n"
						+ "1 - Interface Grafica\n" + "2 - Linha de comando");
				op = Integer.parseInt(aux);

				aux = JOptionPane.showInputDialog("Escolha entre:\n"
						+ "1 - Pesistencia em arquivo\n"
						+ "2 - Pesistencia em memoria");
				op2 = Integer.parseInt(aux);

				teste = true;
			} catch (NumberFormatException evento) {
				JOptionPane.showMessageDialog(null,
						"Formato inválido,informe valores númericos");
			}
		} while (teste == false);

		g = GuiFactory.getDAOFactory(op, op2);

		if (g != null)
			g.execute();

	}

}