package classes;

import java.util.ArrayList;
import java.util.List;

public class TestCycle {
	private String testScenario;
	private	boolean active;
	private	String module;	
	private	String testCase;	
	private String priority;
	private	String dataSheet;	
	private	List<String> identify=new ArrayList<String>();	
	private	String description;
	private String tester;
	private String result;
	public String getTestScenario() {
		return testScenario;
	}
	public void setTestScenario(String testScenario) {
		this.testScenario = testScenario;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDataSheet() {
		return dataSheet;
	}
	public void setDataSheet(String dataSheet) {
		this.dataSheet = dataSheet;
	}
	public List<String> getIdentify() {
		return identify;
	}
	public void setIdentify(List<String> identify) {
		this.identify = identify;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "TestCycle [testScenario=" + testScenario + ", active=" + active
				+ ", module=" + module + ", testCase=" + testCase
				+ ", priority=" + priority + ", dataSheet=" + dataSheet
				+ ", identify=" + identify + ", description=" + description
				+ ", tester=" + tester + ", result=" + result
				+ ", getTestScenario()=" + getTestScenario() + ", isActive()="
				+ isActive() + ", getModule()=" + getModule()
				+ ", getTestCase()=" + getTestCase() + ", getPriority()="
				+ getPriority() + ", getDataSheet()=" + getDataSheet()
				+ ", getIdentify()=" + getIdentify() + ", getDescription()="
				+ getDescription() + ", getTester()=" + getTester()
				+ ", getResult()=" + getResult() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
