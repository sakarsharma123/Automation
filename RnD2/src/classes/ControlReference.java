package classes;

public class ControlReference {
	private	String controlReference;
	private	String path;
	private String identifierValue;
	public String getControlReference() {
		return controlReference;
	}
	public void setControlReference(String controlReference) {
		this.controlReference = controlReference;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getIdentifierValue() {
		return identifierValue;
	}
	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}
	@Override
	public String toString() {
		return "ControlReference [controlReference=" + controlReference
				+ ", path=" + path + ", identifierValue=" + identifierValue
				+ "]";
	}	
	
}
