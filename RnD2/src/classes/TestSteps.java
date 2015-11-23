package classes;

public class TestSteps {
	private String testSteps;
	private String command;
	private String controlReference;
	private String userData_ColumnName;
	private boolean finalSteps;
	public String getTestSteps() {
		return testSteps;
	}
	public void setTestSteps(String testSteps) {
		this.testSteps = testSteps;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getControlReference() {
		return controlReference;
	}
	public void setControlReference(String controlReference) {
		this.controlReference = controlReference;
	}
	public String getUserData_ColumnName() {
		return userData_ColumnName;
	}
	public void setUserData_ColumnName(String userData_ColumnName) {
		this.userData_ColumnName = userData_ColumnName;
	}
	public boolean isFinalSteps() {
		return finalSteps;
	}
	public void setFinalSteps(boolean finalSteps) {
		this.finalSteps = finalSteps;
	}
	@Override
	public String toString() {
		return "TestSteps [testSteps=" + testSteps + ", command=" + command
				+ ", controlReference=" + controlReference
				+ ", userData_ColumnName=" + userData_ColumnName
				+ ", finalSteps=" + finalSteps + "]";
	}
	
}
