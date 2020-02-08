package br.com.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import br.com.utils.Utils;

public class DashboardPage {
	
	/**
	 * @author Massayohi Campos
	 * Criado em Janeiro/2020
	 * @throws InterruptedException
	 * @version 1.0.0 
	 * @since Release 1.0
	 */	
	
	
	/**
	 * Inst�ncia privada do WebDriver que chama a suite de teste.
	 */
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	/**
	 * Construtor que adiciona a inst�ncia do WebDriver para utiliza��o dos m�todos.
	 * 
	 */

	static {
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 40);
		driver.navigate().to(Property.SITE_ADDRESS);
		
	}
	
	//Dashboard
	static By validarTextoDashboard = By.xpath("//li[contains(text(),'Dashboard')]");
	static By validarTextoTasks = By.xpath("//a[contains(text(),'Tasks')]");
	static By validarTextoSettings = By.xpath("//li[contains(text(),'Settings')]");
	static By validarTextoProfile = By.xpath("//a[contains(text(),'Profile')]");
	static By validarTextoPassword = By.xpath("//a[contains(text(),'Password')]");
	
	//New Task
	static By adicionarNewTask = By.id("insert-button");
	static By verificarTituloPagina = By.xpath("//h3[@class='m-b-xs']");
	static By preencherCampoTitle = By.id("title");
	static By preencherCampoDate = By.id("dueDate");
	static By preencherCampoTags = By.xpath("//div[@class='bootstrap-tagsinput form-control']//input");
	static By clicarButtonSave = By.id("form-submit-button");
	static By verificarNewTask = By.id("tasks");
	
	//Altera��o New Task
	static By clicarButtonEdit = By.id("edit-button");
	static By verificarTituloPaginaEdit = By.cssSelector("div.wrapper:nth-child(3) section.content div.container-fluid div.row:nth-child(1) div.col-lg-12 div.view-header:nth-child(1) div.header-title > h3.m-b-xs:nth-child(1)");
	static By preencherCampoTitleAlt = By.name("title");
	static By preencherCampoDateAlt = By.id("dueDate");
	static By preencherCampoTagsAlt = By.xpath("//div[@class='bootstrap-tagsinput form-control focus']//input");
	static By deleteTagAlt = By.xpath("//span[@class='tag label label-info']//span");
	
	//Exclus�o New task
	static By clicarButtonDelete = By.id("delete-button");
	static By clicarButtonNao = By.xpath("//button[@class='btn btn-default']");
	static By clicarButtonSim = By.xpath("//button[@class='btn btn-danger']");
	

	
	public DashboardPage() {
						
	}
	
	// M�todo que verifica o texto exibido na Tela.
	public static void validarTextoDashboard(String dashboard) {
		Utils.isVisible(validarTextoDashboard);
		driver.findElement(validarTextoDashboard).getAttribute(dashboard);
		
	}	
	
	// M�todo que verifica o texto exibido na Tela.
	public static void validarTextoTasks(String tasks) {
		//Utils.isVisible(validarTextoTasks);
		driver.findElement(validarTextoTasks).getAttribute(tasks);
			
	}
	
	// M�todo que verifica o texto exibido na Tela.
	public static void validarTextoSettings(String settings) {
		//Utils.isVisible(validarTextoSettings);
		driver.findElement(validarTextoSettings).getAttribute(settings);
			
	}
	
	// M�todo que verifica o texto exibido na Tela.
	public static void validarTextoProfile(String profile) {
		//Utils.isVisible(validarTextoProfile);
		driver.findElement(validarTextoProfile).getAttribute(profile);
				
	}
	
	// M�todo que verifica o texto exibido na Tela.
	public static void validarTextoPassword(String password) {
		//Utils.isVisible(validarTextoPassword);
		driver.findElement(validarTextoPassword).getAttribute(password);
					
	}
	
	// M�todo que clica no bot�o New para adicionar uma nova Task.
	public static void adicionarNewTask() {
		Utils.isVisible(adicionarNewTask);
		driver.findElement(adicionarNewTask).click();
						
	}
	
	// M�todo que verifica o t�tulo exibido na Tela.
	public static void verificarTituloPagina(String titulo) {
		Utils.isVisible(verificarTituloPagina);
		driver.findElement(verificarTituloPagina).getAttribute(titulo);
		
	}
	
	// M�todo que preenche o campo T�tulo.
	public static void preencherCampoTitle(String titulo1) {
		driver.findElement(preencherCampoTitle).clear();
		driver.findElement(preencherCampoTitle).sendKeys(titulo1);
		
	}
	
	// M�todo que preenche o campo T�tulo na Altera��o.
	public static void preencherCampoTitleAlt(String titulo4) {
		Utils.isVisible(preencherCampoTitleAlt);
		driver.findElement(preencherCampoTitleAlt).clear();
		driver.findElement(preencherCampoTitleAlt).sendKeys(titulo4);
			
	}
	
	// M�todo que preenche o campo Date.
	public static void preencherCampoDate(String date) {
		driver.findElement(preencherCampoDate).clear();
		driver.findElement(preencherCampoDate).sendKeys(date);
			
	}
	
	// M�todo que preenche o campo Date na Altera��o.
	public static void preencherCampoDateAlt(String date1) {
		Utils.isVisible(preencherCampoDateAlt);
		driver.findElement(preencherCampoDateAlt).clear();
		driver.findElement(preencherCampoDateAlt).sendKeys(date1);
			
	}
		
	// M�todo que preenche o campo Tags.
	public static void preencherCampoTags(String tags) {
		driver.findElement(preencherCampoTags).clear();
		driver.findElement(preencherCampoTags).sendKeys(tags);
			
	}
	
	// M�todo que preenche o campo Tags na altera��o.
	public static void preencherCampoTagsAlt(String tags1) {
		Utils.isVisible(preencherCampoTagsAlt);
		driver.findElement(preencherCampoTagsAlt).clear();
		driver.findElement(preencherCampoTagsAlt).sendKeys(tags1);
				
	}
		
	// M�todo que clica no bot�o Detele
		public static void deleteTagAdicionada() throws FindFailed {
			driver.findElement(deleteTagAlt).click();
			//Utils.buttomByPathClick("\\imagens\\deletetag.jpg");
	
		}
	
	// M�todo que clica no bot�o Salvar.
	public static void clicarButtonSave() {
		Utils.isVisible(clicarButtonSave);
		driver.findElement(clicarButtonSave).click();
		
	}
	
	// M�todo que clica no bot�o New para adicionar uma nova Task.
	public static void verificarNewTask(String titulo2) {
		Utils.isVisible(verificarNewTask);
		driver.findElement(verificarNewTask).getAttribute(titulo2);
			
	}
	
	// M�todo que clica no bot�o Editar.
	public static void clicarButtonEdit() {
		Utils.isVisible(clicarButtonEdit);
		driver.findElement(clicarButtonEdit).click();
			
	}
	
	// M�todo que verifica o t�tulo exibido na Tela.
	public static void verificarTituloPaginaEdit(String titulo3) {
		Utils.isVisible(verificarTituloPaginaEdit);
		driver.findElement(verificarTituloPaginaEdit).getAttribute(titulo3);
				
	}
	
	// M�todo que clica no bot�o Delete da nova Task.
	public static void clicarButtonDelete() {
		Utils.isVisible(clicarButtonDelete);
		driver.findElement(clicarButtonDelete).click();
	
	}
	
	// M�todo que clica no bot�o N�o da nova Task.
	public static void clicarButtonNao() {
		Utils.isVisible(clicarButtonNao);
		driver.findElement(clicarButtonNao).click();
		
	}
	
	// M�todo que clica no bot�o Sim da nova Task.
	public static void clicarButtonSim() {
		Utils.isVisible(clicarButtonSim);
		driver.findElement(clicarButtonSim).click();
			
	}
	

}
