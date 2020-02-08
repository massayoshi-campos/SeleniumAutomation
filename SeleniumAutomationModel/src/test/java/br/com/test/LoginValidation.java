package br.com.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.common.LoginPage;

public class LoginValidation extends BaseTestCase{
	
	/**
	 * @author Massayohi Campos
	 * Criado em Janeiro/2020
	 * @throws InterruptedException 
	 * @version 1.0.0
     * @since Release 1.0
	 */	
	
	@Test
	public void LoginValidationTest() throws Exception{
		
		
		//Login
		LoginPage.preencherCampoEmail("eu@papito.io");
		LoginPage.preencherCampopassword("pwd123");
		LoginPage.clicarButtonLogin();
		LoginPage.textPresentHome("Hello, Papito");
		LoginPage.clicarLogout();
		LoginPage.clicarButtonSair();
		
		//Login Falha no E-mail
		Thread.sleep(1500);
		LoginPage.preencherCampopassword("pwd123");
		LoginPage.clicarButtonLogin();
		Thread.sleep(2000);
		LoginPage.verificarMensagemEmail("Email is required");
		LoginPage.limparCamposReflesh();
		
		//Login Falha no password
		Thread.sleep(1500);
		LoginPage.preencherCampoEmail("eu@papito.io");
		LoginPage.clicarButtonLogin();
		Thread.sleep(2000);
		LoginPage.verificaMensagemPassword("Password is required");
		LoginPage.limparCamposReflesh();
		
		
	}
	
}
