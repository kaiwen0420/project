package jdbc.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import jdbc.JDBCUtil;

public class DepartmentDao {
	
	private Connection con;
	private PreparedStatement ps;
	public static void main(String[] args) {
		new DepartmentDao().testUpdate();
	}
	
	public void testInsert() {
		DepartmentDao dd = new DepartmentDao();
		DepartmentModel dm = new DepartmentModel();
		dm.setDepartment_code("项目经理089");
		dm.setDepartment_name("经理室");
		dm.setDepartment_tel("110");
		dm.setMany(3);
		insert(dm);
	}
	
	public String insert(DepartmentModel dm) {
		String sql = "insert into information_manage.department(department_code,department_name,department_tel,many)values(?,?,?,?);";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dm.getDepartment_code());
			ps.setString(2, dm.getDepartment_name());
			ps.setString(3, dm.getDepartment_tel());
			ps.setInt(4, dm.getMany());
			return ps.executeUpdate() + "";
		} catch (Exception e) {
                e.printStackTrace();
		} finally {
			JDBCUtil.close(con,ps,null);
		}
		return null;
	}
	
	public void testDelete() {
		DepartmentDao dd = new DepartmentDao();
		DepartmentModel dm = new DepartmentModel();
		dm.setDepartment_code("项目经理089");
		delete(dm);
	}
	
	public String delete(DepartmentModel dm) {
		String sql = "delete from information_manage.department where department_code=?;";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dm.getDepartment_code());
			return ps.executeUpdate()+"";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, ps, null);
		}
		return null;
	}
	
	public void testUpdate() {
		DepartmentDao dd = new DepartmentDao();
		DepartmentModel dm = new DepartmentModel();
		dm.setDepartment_name("鸡你太美");
		dm.setDepartment_tel("120");
		dm.setMany(3);
		update(dm);
	}
	
	public String update(DepartmentModel dm) {
		String sql = "Update information_manage.department set department_name=?,department_tel=?,many=? where id=5;";
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dm.getDepartment_name());
			ps.setString(2, dm.getDepartment_tel());
			ps.setInt(3, dm.getMany());
			return ps.executeUpdate() + "";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, ps, null);
		}
		return null;
	}

}
