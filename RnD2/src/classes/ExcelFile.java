package classes;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	 public static final FrameWorkInput FRAMEWORK_INPUT = new FrameWorkInput();
	 public static final DataInput DATA_INPUT = new DataInput();

	 public static void initialize() {
		 try {
			/** Creating Input Stream **/
			FileInputStream myInput = new FileInputStream("./ExcelFiles/FrameworkInput.xlsx");
			FileInputStream myInput2 = new FileInputStream("./ExcelFiles/DataInput.xlsx");
			/** Create a workbook using the File System **/
			XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
			XSSFWorkbook myWorkBook2 = new XSSFWorkbook(myInput2);
			/** Get the first sheet from workbook **/
			 XSSFSheet testCycleSheet = myWorkBook.getSheet("TestCycle");
             FRAMEWORK_INPUT.setTestCycleList(getTestCycleFromSheet(testCycleSheet));
			 XSSFSheet testCaseSheet = myWorkBook.getSheet("TestCase");
             FRAMEWORK_INPUT.setTestCasesList(getTestCasesFromSheet(testCaseSheet));
			 XSSFSheet testStepsSheet = myWorkBook.getSheet("TestSteps");
             FRAMEWORK_INPUT.setTestStepsList(getTestStepsFromSheet(testStepsSheet));
			 XSSFSheet controlReferenceSheet = myWorkBook.getSheet("ControlReference");
             FRAMEWORK_INPUT.setControlReferenceList(getControlReferenceFromSheet(controlReferenceSheet));
             /** Get the Second sheet from workbook **/
      	  	 XSSFSheet userDataSheet = myWorkBook2.getSheet("UserData");
             DATA_INPUT.setUserDataList(getUserDataFromSheet(userDataSheet));
        	 myWorkBook.close();
        	 myWorkBook2.close();
             } catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static List<TestCycle>  getTestCycleFromSheet(XSSFSheet sheet){
		List<TestCycle> testCycleList = new ArrayList<TestCycle>();
		Iterator<?> rowIter = sheet.rowIterator();
		while (rowIter.hasNext()) {
			XSSFRow myRow = (XSSFRow) rowIter.next();
			if (myRow.getCell(0) != null) {
				TestCycle testCycle = new TestCycle();
				Iterator<?> cellIter = myRow.cellIterator();
				Vector<XSSFCell> cellStoreVector = new Vector<XSSFCell>();
				int counter=0;
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
					switch (counter) {
					case 0:
						testCycle.setTestScenario(myCell.getStringCellValue());
						break;
					case 1:
						testCycle.setActive(Boolean.parseBoolean(myCell.getStringCellValue()));
						break;
					case 2:
						testCycle.setModule(myCell.getStringCellValue());
						break;
					case 3:
						testCycle.setTestCase(myCell.getStringCellValue());
						break;
					case 4:
						testCycle.setPriority(myCell.getStringCellValue());
						break;
					case 5:
						testCycle.setDataSheet(myCell.getStringCellValue());
						break;
					case 6:
						String str[]=myCell.getStringCellValue().split(",");
						for (String rowId : str) {
							testCycle.getIdentify().add(rowId);
						};
						break;
					case 7:
						testCycle.setDescription(myCell.getStringCellValue());
						break;
					case 8:
						testCycle.setTester(myCell.getStringCellValue());
						break;
					case 9:
						testCycle.setResult(myCell.getStringCellValue());
						break;
					}
					counter++;
				}
				testCycleList.add(testCycle);
			}
		}
		return testCycleList;
	}
	private static List<TestCases>  getTestCasesFromSheet(XSSFSheet sheet){
		List<TestCases> testCasesList = new ArrayList<TestCases>();
		Iterator<?> rowIter = sheet.rowIterator();
		while (rowIter.hasNext()) {
			XSSFRow myRow = (XSSFRow) rowIter.next();
			if (myRow.getCell(0) != null) {
				TestCases testCases = new TestCases();
				Iterator<?> cellIter = myRow.cellIterator();
				Vector<XSSFCell> cellStoreVector = new Vector<XSSFCell>();
				int counter=0;
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
					switch (counter) {
					case 0:
						testCases.setTestCaseName(myCell.getStringCellValue());
						break;
					case 1:
						testCases.setTestSteps(myCell.getStringCellValue());
						break;
					case 2:
						testCases.setProceedOnFail(Boolean.parseBoolean(myCell.getStringCellValue()));
						break;
					case 3:
						testCases.setDescription(myCell.getStringCellValue());
						break;
					}
					counter++;
				}
				testCasesList.add(testCases);
			}
		}
		return testCasesList;
	}
	private static List<TestSteps>  getTestStepsFromSheet(XSSFSheet sheet){
		List<TestSteps> testStepsList = new ArrayList<TestSteps>();
		Iterator<?> rowIter = sheet.rowIterator();
		while (rowIter.hasNext()) {
			XSSFRow myRow = (XSSFRow) rowIter.next();
			if (myRow.getCell(0) != null) {
				TestSteps testSteps = new TestSteps();
				Iterator<?> cellIter = myRow.cellIterator();
				Vector<XSSFCell> cellStoreVector = new Vector<XSSFCell>();
				int counter=0;
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
					switch (counter) {
					case 0:
						testSteps.setTestSteps(myCell.getStringCellValue());
						break;
					case 1:
						testSteps.setCommand(myCell.getStringCellValue());
						break;
					case 2:
						testSteps.setControlReference(myCell.getStringCellValue());
						break;
					case 3:
						testSteps.setUserData_ColumnName(myCell.getStringCellValue());
						break;
					case 4:
						testSteps.setFinalSteps(Boolean.parseBoolean(myCell.getStringCellValue()));
						break;
					}
					counter++;
				}
				testStepsList.add(testSteps);
			}
		}
		return testStepsList;
	}
	private static List<ControlReference>  getControlReferenceFromSheet(XSSFSheet sheet){
		List<ControlReference> controlReferenceList = new ArrayList<ControlReference>();
		Iterator<?> rowIter = sheet.rowIterator();
		while (rowIter.hasNext()) {
			XSSFRow myRow = (XSSFRow) rowIter.next();
			if (myRow.getCell(0) != null) {
				ControlReference controlReference = new ControlReference();
				Iterator<?> cellIter = myRow.cellIterator();
				Vector<XSSFCell> cellStoreVector = new Vector<XSSFCell>();
				int counter=0;
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
					switch (counter) {
					case 0:
						controlReference.setControlReference(myCell.getStringCellValue());
						break;
					case 1:
						controlReference.setPath(myCell.getStringCellValue());
						break;
					case 2:
						controlReference.setIdentifierValue(myCell.getStringCellValue());
						break;
					}
					counter++;
				}
				controlReferenceList.add(controlReference);
			}
		}
		return controlReferenceList;
	}
	/** Get the Second sheet from workbook **/
	private static List<UserData>  getUserDataFromSheet(XSSFSheet sheet){
		List<UserData> userDataList = new ArrayList<UserData>();
		Iterator<?> rowIter = sheet.rowIterator();
		while (rowIter.hasNext()) {
			XSSFRow myRow = (XSSFRow) rowIter.next();
			if (myRow.getCell(0) != null) {
				UserData userData = new UserData();
				Iterator<?> cellIter = myRow.cellIterator();
				Vector<XSSFCell> cellStoreVector = new Vector<XSSFCell>();
				int counter=0;
				while (cellIter.hasNext()) {
					XSSFCell myCell = (XSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
					switch (counter) {
					case 0:
						userData.setIdentify(myCell.getStringCellValue());
						break;
					case 1:
						userData.setAdmin_Account(myCell.getStringCellValue());
						break;
					case 2:
						userData.setAdmin_UserName(myCell.getStringCellValue());
						break;
					case 3:
						userData.setUserRoleName(myCell.getStringCellValue());
						break;
					case 4:
						userData.setNormal_Sales(myCell.getStringCellValue());
						break;
					case 5:
						userData.setFirstName(myCell.getStringCellValue());
						break;
					case 6:
						userData.setReset_FirstName(myCell.getStringCellValue());
						break;
					case 7:
						userData.setSecondName(myCell.getStringCellValue());
						break;
					case 8:
						userData.setReset_SecondName(myCell.getStringCellValue());
						break;
					case 9:
						userData.setEmail(myCell.getStringCellValue());
						break;
					case 10:
						userData.setReset_Email(myCell.getStringCellValue());
						break;
					case 11:
						userData.setPassword(myCell.getStringCellValue());
						break;
					case 12:
						userData.setReset_Password(myCell.getStringCellValue());
						break;
					case 13:
						userData.setUserName(myCell.getStringCellValue());
						break;
					case 14:
						userData.setReset_UserName(myCell.getStringCellValue());
						break;
					case 15:
						userData.setSecurity_Question1(myCell.getStringCellValue());
						break;
					case 16:
						userData.setAnswer1(myCell.getStringCellValue());
						break;
					case 17:
						userData.setSecurity_Question2(myCell.getStringCellValue());
						break;
					case 18:
						userData.setAnswer2(myCell.getStringCellValue());
						break;
					case 19:
						userData.setSecondary_Password(myCell.getStringCellValue());
						break;
					case 20:
						userData.setResult(myCell.getStringCellValue());
						break;
					}
					counter++;
				}
				userDataList.add(userData);
			}
		}
		return userDataList;
	}
}