package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import classes.ControlReference;
import classes.Counter;
import classes.ExcelFile;
import classes.SendMail;
import classes.SendMail2;
import classes.TestCases;
import classes.TestCycle;
import classes.TestSteps;
import classes.UserData;
import classes.WriteInExcel;

public class Working {
	Logger logger = Logger.getLogger(getClass());
	private WebDriver driver;
	WriteInExcel writeInExcel;
	private boolean acceptNextAlert = false;
	Map<String, UserData> userDataMap = new HashMap<String, UserData>();
	Map<String, List<ControlReference>> controlreferenceMap = new HashMap<String, List<ControlReference>>();
	Map<String, List<TestCases>> testCaseMap = new HashMap<String, List<TestCases>>();
	Map<String, List<TestSteps>> testStepMap = new HashMap<String, List<TestSteps>>();
	Properties properties;
	@Before
	public void setUp() throws Exception {
		ExcelFile.initialize();
		writeInExcel=new WriteInExcel(0);
		for (UserData userData : ExcelFile.DATA_INPUT.getUserDataList()) {
			userDataMap.put(userData.getIdentify(), userData);
		}
		for (TestCases testcase : ExcelFile.FRAMEWORK_INPUT.getTestCasesList()) {
			if (testcase.isProceedOnFail()) {
				List<TestCases> testList = testCaseMap.get(testcase.getTestCaseName());
				if (testList == null) {
					testList = new ArrayList<TestCases>();
					testCaseMap.put(testcase.getTestCaseName(), testList);
				}
				testList.add(testcase);
			}
		}
		for (TestSteps teststep : ExcelFile.FRAMEWORK_INPUT.getTestStepsList()) {
			List<TestSteps> testList = testStepMap.get(teststep.getTestSteps());
			if (testList == null) {
				testList = new ArrayList<TestSteps>();
				testStepMap.put(teststep.getTestSteps(), testList);
			}
			testList.add(teststep);
		}

		for (ControlReference controlreference : ExcelFile.FRAMEWORK_INPUT.getControlReferenceList()) {
			List<ControlReference> testList = controlreferenceMap.get(controlreference.getControlReference());
			if (testList == null) {
				testList = new ArrayList<ControlReference>();
				controlreferenceMap.put(controlreference.getControlReference(),testList);
			}
			testList.add(controlreference);
		}
		properties = new Properties();
		try {
			properties.load(this.getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		logger.info("Logs file has been initilized");
	}
	private String getInputData(String dataInput_ColumnName,String dataInput_identify) {
		UserData userdata = userDataMap.get(dataInput_identify);
		return getColumnFromUserData(userdata,dataInput_ColumnName);
	}
	public String getColumnFromUserData(UserData data, String columnName){
		String value = null;
		switch (columnName) {
		case "Admin_Account":
			value = data.getAdmin_Account();
			break;
		case "Admin_UserName":
			value = data.getAdmin_UserName();
			break;
		case "UserRoleName":
			value = data.getUserRoleName();
			break;
		case "Normal_Sales":
			value = data.getNormal_Sales();
			break;
		case "FirstName":
			value = data.getFirstName();
			break;
		case "Reset_FirstName":
			value = data.getReset_FirstName();
			break;
		case "SecondName":
			value = data.getSecondName();
			break;
		case "Reset_SecondName":
			value = data.getReset_SecondName();
			break;
		case "Email":
			value = data.getEmail();
			break;
		case "Reset_Email":
			value = data.getReset_Email();
			break;
		case "Password":
			value = data.getPassword();
			break;
		case "Reset_Password":
			value = data.getReset_Password();
			break;
		case "UserName":
			value = data.getUserName();
			break;
		case "Reset_UserName":
			value = data.getReset_UserName();
			break;
		case "Security_Question1":
			value = data.getSecurity_Question1();
			break;
		case "Answer1":
			value = data.getAnswer1();
			break;
		case "Security_Question2":
			value = data.getSecurity_Question2();
			break;
		case "Answer2":
			value = data.getAnswer2();
			break;
		case "Secondary_Password":
			value = data.getSecondary_Password();
			break;
		case "Result":
			value = data.getResult();
			break;
		default:
			break;
		}
		return value;
	}
	public void execCommand(String command, String path,
			String identifierValue, String inputData) {
		By by = findByComponent(path, identifierValue);
		if (by != null) {
			if (command.equalsIgnoreCase("click")) {
				driver.findElement(by).click();
			} else if (command.equalsIgnoreCase("SendText")) {
				driver.findElement(by).sendKeys(inputData);
			} else if (command.equalsIgnoreCase("clear")) {
				driver.findElement(by).clear();
			}
		}
	}
	public By findByComponent(String path, String identifierValue) {
		By by = null;
		if (path.equals("xpath")) {
			by = By.xpath(identifierValue);
		} else if (path.equals("cssSelector")) {
			by = By.cssSelector(identifierValue);
		} else if (path.equals("linkText")) {
			by = By.linkText(identifierValue);
		} else if (path.equals("id")) {
			by = By.id(identifierValue);
		} else if (path.equals("name")) {
			by = By.name(identifierValue);
		} else if (path.equals("className")) {
			by = By.className(identifierValue);
		}
		return by;
	}
	public void login(String username, String password, String env, String identifyRow) {
			if (getInputData("UserRoleName", identifyRow).equals("Internal")){
			String url = "https://" + username + ":" + password + "@" + env	+ ".windstreamonline.com" + "/pol/internal/CustomerSearch.do";
			System.out.println(url);
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else{
		String url = "https://" + env + ".windstreamonline.com" + "/pol/Login.action";
		System.out.println(url);
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		}
	@Test
	public void test1() throws Exception {
		List<Counter> counterList=new ArrayList<>();
		for ( int i = 1 ; i < ExcelFile.FRAMEWORK_INPUT.getTestCycleList().size() ; i++) {
			Counter counter=new Counter();
			try{
				int rowCounter=1;
				TestCycle cycle=ExcelFile.FRAMEWORK_INPUT.getTestCycleList().get(i);
				System.out.println("===============================================================================================================================================================");
				if (cycle.isActive()) {
					for(String identifyRow : cycle.getIdentify()) {	
						counter.incrementTestCycleCounter();
						login(properties.getProperty("UserName", ""),properties.getProperty("Password", ""),properties.getProperty("env", ""),identifyRow);
						logger.info("=========================================== Test Cycle = "+cycle.getTestScenario()+" Started. ==========================================================");
						List<TestCases> testList = testCaseMap.get(cycle.getTestCase());
						logger.info("Test Case Name : " + cycle.getTestCase());
						logger.info("=================================================");
						logger.info("Test Case Steps Are : ");
						logger.info("=================================================");
						int j = 0;
						counter.incrementDataCounter();
						for (TestCases testcase : testList) {
							counter.incrementTestCaseCounter();
							j++;
							List<TestSteps> testStep = testStepMap.get(testcase.getTestSteps());
							if(testStep == null){
								continue;
							}
							for (TestSteps steps : testStep) {
								counter.incrementTestStepCounter();
								List<ControlReference> controlReferences = controlreferenceMap.get(steps.getControlReference());
								//IDENTIFY 
								String inputData = getInputData(steps.getUserData_ColumnName(),identifyRow);
								for (ControlReference controlReference : controlReferences) {
									logger.info(steps.getTestSteps() + " || " + steps.getCommand() + " || " + steps.getUserData_ColumnName() + " :- " + inputData);
									try{
										execCommand(steps.getCommand(),controlReference.getPath(),controlReference.getIdentifierValue(),inputData);
									}catch(Exception e){
										logger.error(e.getStackTrace());
									}
									if(driver.findElements(By.id("searchResultsDiv")).size() > 0){
										driver.findElement(By.linkText(getInputData("Admin_UserName", identifyRow))).click();
									}
									if(j == (testList.size()-1)){
										if (driver.findElements(By.xpath("//div[contains(text(), 'Congratulations!')]")).size() > 0) {
											acceptNextAlert=true;
											logger.info("PASS :: New User >> "+ getInputData("UserName", identifyRow) + " <<Created");
										}else if (driver.findElements(By.xpath("//div[contains(text(), 'Error')]")).size() > 0){
											acceptNextAlert=false;
											logger.info("FAIL :: User >> " + getInputData("UserName", identifyRow) + " <<All Ready Exists");
										}
									}
								}
							}
						}
						writeInExcel.updateResult(rowCounter, acceptNextAlert);
						rowCounter++;
						logger.info("===================================================================================================================================");
						logger.info("UserName is :" + getInputData("UserName", identifyRow) + " || "+" User Email is: " + getInputData("Email", identifyRow) + " || " + "User Password is : " + getInputData("Password", identifyRow));
						logger.info("===================================================================================================================================");
						System.out.println("===============================================================================================================================================================");
					}
				counterList.add(counter);
				}
				logger.info(cycle.getTestScenario() + " Completed");
				logger.info("=========================================== Test Cycle = "+cycle.getTestScenario() +" Finished. =========================================================");
				if(driver.findElements(By.xpath("//*[@id='searchResultsDiv']/span")).size() > 0){
					driver.findElement(By.name("searchText")).clear();
					logger.info("No Admin User Found");
					acceptNextAlert=false;
					continue;
				} else if(driver.findElements(By.id("errorBox")).size() > 0){
					driver.findElement(By.name("searchText")).clear();
					logger.info("No Admin User Found");
					acceptNextAlert=false;
					continue;
				}
			}catch(Exception e){
				logger.error(e.getStackTrace());
			}
		
		} //for
//		 for(Counter counter: counterList){
//			logger.info("===================================================================================================================================");
//			logger.info("Number Of Test Cycle Executed " + counter.getTestCycleCounter());
//			logger.info("Number Of Test Case Executed "  + counter.getTestCaseCounter());
//			logger.info("Number Of Test Steps Executed " + counter.getTestStepCounter() );
//			logger.info("Number Of Data Executed "       + counter.getDataCounter() );
//			logger.info("Number Of Test Result" + "Passed = " + "Failed = ");
//			logger.info("===================================================================================================================================");
//		}
	    writeInExcel.close();
		//SendMail.sendMail();
		//SendMail2.sendMail2();
		logger.info("Logs file has Written And Emailed");
		logger.info("=========================================== All Test Cycle Completed And Email Of Result/Logs Sent. ===============================");
		for(Counter counter: counterList){
			logger.info("===================================================================================================================================");
			logger.info("Number Of Test Cycle Executed " + counter.getTestCycleCounter());
			logger.info("Number Of Test Case Executed "  + counter.getTestCaseCounter());
			logger.info("Number Of Test Steps Executed " + counter.getTestStepCounter() );
			logger.info("Number Of Data Executed "       + counter.getDataCounter() );
//			logger.info("Number Of Test Result" + "Passed = " + "Failed = ");
			logger.info("===================================================================================================================================");
		}
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
}
