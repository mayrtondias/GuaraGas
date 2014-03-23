package gui;

public abstract class GuiFactory {
	public static final int INTERFACEGRAFICA = 1;
	public static final int LINHACOMANDO = 2;

	public abstract void execute();

	public static GuiFactory getDAOFactory(int whichFactory, int whichFactoryDAO) {

		switch (whichFactory) {
		case INTERFACEGRAFICA:
			return new GuiApp(whichFactoryDAO);
		case LINHACOMANDO:
			return new LinhaApp(whichFactoryDAO);
		default:
			return null;
		}

	}
}
