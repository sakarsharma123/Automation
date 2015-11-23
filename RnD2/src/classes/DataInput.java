package classes;

import java.util.List;


public class DataInput{
	
	private List<UserData> userDataList;

	public List<UserData> getUserDataList() {
		return userDataList;
	}

	public void setUserDataList(List<UserData> userDataList) {
		this.userDataList = userDataList;
	}

	@Override
	public String toString() {
		return "DataInput [userDataList=" + userDataList + "]";
	}
	
}
