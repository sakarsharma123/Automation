package classes;

public class TestCases {
	private  String testCaseName;
	private String testSteps;
	private boolean proceedOnFail;
	private String description;
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getTestSteps() {
		return testSteps;
	}
	public void setTestSteps(String testSteps) {
		this.testSteps = testSteps;
	}
	public boolean isProceedOnFail() {
		return proceedOnFail;
	}
	public void setProceedOnFail(boolean proceedOnFail) {
		this.proceedOnFail = proceedOnFail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TestCases [testCaseName=" + testCaseName + ", testSteps="
				+ testSteps + ", proceedOnFail=" + proceedOnFail
				+ ", description=" + description + "]";
	}

}
