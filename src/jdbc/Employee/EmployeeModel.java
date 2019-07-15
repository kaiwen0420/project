package jdbc.Employee;

import java.sql.Timestamp;

public class EmployeeModel {
	private int id =1;
	private String department_code;
	private String person_code;
	private String person_name;
	private String gender;
	private String birthday;
	private String tel;
	private Timestamp entryTime;
	
	private Timestamp timeBegin;
	private Timestamp timeEnd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
	public String getPerson_code() {
		return person_code;
	}
	public void setPerson_code(String person_code) {
		this.person_code = person_code;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Timestamp getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Timestamp entryTime) {
		this.entryTime = entryTime;
	}
	public Timestamp getTimeBegin() {
		return timeBegin;
	}
	public void setTimeBegin(Timestamp timeBegin) {
		this.timeBegin = timeBegin;
	}
	public Timestamp getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", department_code=" + department_code + ", person_code=" + person_code
				+ ", person_name=" + person_name + ", gender=" + gender + ", birthday=" + birthday + ", tel=" + tel
				+ ", entryTime=" + entryTime + ", timeBegin=" + timeBegin + ", timeEnd=" + timeEnd + "]";
	}

	

}
