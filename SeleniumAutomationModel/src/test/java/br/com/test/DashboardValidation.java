package br.com.test;

import org.junit.Test;
import org.sikuli.script.FindFailed;

import br.com.common.DashboardPage;
import br.com.common.LoginPage;

public class DashboardValidation extends BaseTestCase{
	
	/**
	 * @author Massayohi Campos
	 * Criado em Janeiro/2020
	 * @throws InterruptedException 
	 * @throws FindFailed 
	 *  @version 1.0.0 
	 *  @since Release 1.0
	 */	
	
	@Test
	public void DashboardValidationTest() throws InterruptedException, FindFailed {
		
		//Login
		LoginPage.preencherCampoEmail("eu@papito.io");
		LoginPage.preencherCampopassword("pwd123");
		LoginPage.clicarButtonLogin();
		
		//Validar Texto Dashboard
		Thread.sleep(1500);
		DashboardPage.validarTextoDashboard("Dashboard");
		DashboardPage.validarTextoTasks("Tasks");
		DashboardPage.validarTextoSettings("Settings");
		DashboardPage.validarTextoProfile("Profile");
		DashboardPage.validarTextoPassword("Password");
		
		//Adicionar uma nova Task
		Thread.sleep(1500);
		DashboardPage.adicionarNewTask();
		DashboardPage.verificarTituloPagina("New Task");
		DashboardPage.preencherCampoTitle("Tarefa Teste Automação");
		DashboardPage.preencherCampoDate("20/01/2020");
		DashboardPage.preencherCampoTags("Modelo de Automação Teste");
		DashboardPage.clicarButtonSave();
		DashboardPage.verificarNewTask("Tarefa Teste Automação");
		
		//Alterar New Task
		Thread.sleep(1500);
		DashboardPage.clicarButtonEdit();
		DashboardPage.preencherCampoTitleAlt("Alterado com sucesso");
		DashboardPage.preencherCampoDateAlt("13/11/1986");
		DashboardPage.deleteTagAdicionada();
		DashboardPage.preencherCampoTagsAlt("Modelo alterado com sucesso");
		DashboardPage.clicarButtonSave();
		DashboardPage.verificarNewTask("Modelo alterado com sucesso");
		
		//Excluir New Task
		DashboardPage.clicarButtonDelete();
		DashboardPage.clicarButtonNao();
		DashboardPage.clicarButtonDelete();
		DashboardPage.clicarButtonSim();

	}
}
