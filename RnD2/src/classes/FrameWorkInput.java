package classes;

import java.util.List;


public class FrameWorkInput {
	
	
	private List<TestCycle> testCycleList;
	private List<TestCases> testCasesList;
	private List<TestSteps> testStepsList;
	private List<ControlReference> controlReferenceList;
	

	public List<TestCases> getTestCasesList() {
		return testCasesList;
	}

	public void setTestCasesList(List<TestCases> testCasesList) {
		this.testCasesList = testCasesList;
	}

	public List<TestCycle> getTestCycleList() {
		return testCycleList;
	}

	public void setTestCycleList(List<TestCycle> testCycleList) {
		this.testCycleList = testCycleList;
	}

	public List<TestSteps> getTestStepsList() {
		return testStepsList;
	}

	public void setTestStepsList(List<TestSteps> testStepsList) {
		this.testStepsList = testStepsList;
	}

	public List<ControlReference> getControlReferenceList() {
		return controlReferenceList;
	}

	public void setControlReferenceList(List<ControlReference> controlReferenceList) {
		this.controlReferenceList = controlReferenceList;
	}	
}





