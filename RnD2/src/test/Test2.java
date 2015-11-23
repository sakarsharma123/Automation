package test;

import classes.ExcelFile;

public class Test2 {
	public static void main(String[] args){
    	System.out.println("========================================");
    	ExcelFile.initialize();
    	System.out.println(ExcelFile.FRAMEWORK_INPUT.getTestCycleList());
    	System.out.println(ExcelFile.FRAMEWORK_INPUT.getTestCasesList());
    	System.out.println(ExcelFile.FRAMEWORK_INPUT.getTestStepsList());
    	System.out.println(ExcelFile.FRAMEWORK_INPUT.getControlReferenceList());
    	System.out.println(ExcelFile.DATA_INPUT.getUserDataList());
    	System.out.println("============== Excel file initlized successfully========");
    }
}