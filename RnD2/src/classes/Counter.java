package classes;


public class Counter {
	int testCycleCounter;
	int testCaseCounter;
	int testStepCounter;
	int dataCounter;
	public int getTestCycleCounter() {
		return testCycleCounter;
	}
	public void setTestCycleCounter(int testCycleCounter) {
		this.testCycleCounter = testCycleCounter;
	}
	public int getTestCaseCounter() {
		return testCaseCounter;
	}
	public void setTestCaseCounter(int testCaseCounter) {
		this.testCaseCounter = testCaseCounter;
	}
	public int getTestStepCounter() {
		return testStepCounter;
	}
	public void setTestStepCounter(int testStepCounter) {
		this.testStepCounter = testStepCounter;
	}
	public int getDataCounter() {
		return dataCounter;
	}
	public void setDataCounter(int dataCounter) {
		this.dataCounter = dataCounter;
	}
	@Override
	public String toString() {
		return "Counter [testCycleCounter=" + testCycleCounter
				+ ", testCaseCounter=" + testCaseCounter + ", testStepCounter="
				+ testStepCounter + ", dataCounter=" + dataCounter + "]";
	}
	public void incrementDataCounter() {
		// TODO Auto-generated method stub
		dataCounter=dataCounter+1;
	}
	public void incrementTestStepCounter() {
		// TODO Auto-generated method stub
		testStepCounter=testStepCounter+1;
	}
	public void incrementTestCaseCounter() {
		// TODO Auto-generated method stub
		testCaseCounter=testCaseCounter+1;
	}
	public void incrementTestCycleCounter() {
		// TODO Auto-generated method stub
		testCycleCounter=testCycleCounter+1;
	}


}
