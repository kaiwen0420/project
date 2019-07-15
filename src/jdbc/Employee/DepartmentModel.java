package jdbc.Employee;

public class DepartmentModel {
	private int id =1;
	private String department_code;
	private String department_name;
	private String department_tel;
	private int many;
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
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_tel() {
		return department_tel;
	}
	public void setDepartment_tel(String department_tel) {
		this.department_tel = department_tel;
	}
	public int getMany() {
		return many;
	}
	public void setMany(int many) {
		this.many = many;
	}
	@Override
	public String toString() {
		return "DepartmentModel [id=" + id + ", department_code=" + department_code + ", department_name="
				+ department_name + ", department_tel=" + department_tel + ", many=" + many + "]";
	}
	

}
