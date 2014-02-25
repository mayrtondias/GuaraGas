package teste;

import static org.junit.Assert.*;
import gui.GuaraGasApp;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TesteGuaraGasApp {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVerificarCampo() {
		Assert.assertEquals(true, GuaraGasApp.verificarCampo("Usuario bom", 50, 5) );
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testVerificarEmail() {
		Assert.assertEquals(true, GuaraGasApp.verificarEmail("meuemail@hotmail.com"));
	}

}
