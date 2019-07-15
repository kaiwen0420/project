package jdbc.Employee;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCUtil;

public class EmployeeDao {
	private Connection conn;
	private PreparedStatement ps;
	
	public static void main(String[] args) {
		new EmployeeDao().testSelect();
	}
	
	public void testInsert() { //插入数据
		EmployeeDao ed = new EmployeeDao();
		EmployeeModel model = new EmployeeModel();
		model.setPerson_code("9529");
		model.setPerson_name("王凯问");
		model.setGender("男");
		model.setTel("76879454");
		model.setBirthday("1991.02.20");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Date d = sdf.parse("2008-11-31");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		model.setEntryTime(ts);
		model.setDepartment_code("项目经理088");
		insert(model);
	}
	
	public String insert(EmployeeModel model) {
		String sql = "insert into information_manage.person(person_code,person_name,gender,birthday,entryTime,tel,department_code) values(?,?,?,?,?,?,?);";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,model.getPerson_code());
			ps.setString(2,model.getPerson_name());
			ps.setString(3,model.getGender());
			ps.setString(4,model.getBirthday());
			ps.setTimestamp(5,model.getEntryTime());
			ps.setString(6,model.getTel());
			ps.setString(7, model.getDepartment_code());
			return ps.executeUpdate() + "";
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps, null);
		}
		return null;
	}
	
	public void testDelete() {
		EmployeeDao ed = new EmployeeDao();
		EmployeeModel model = new EmployeeModel();
		model.setPerson_code("9529");
		ed.delete(model);
	}
	
	public String delete(EmployeeModel model) { //删除数据
		String sql="delete from information_manage.person where person_code=?;";
		try {
			conn=JDBCUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getPerson_code());
			return ps.executeUpdate()+ "";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps, null);
		}
		return null;
	}
	
	public void testUpdate() {//修改数据
		EmployeeDao ed = new EmployeeDao();
		EmployeeModel model = new EmployeeModel();
		model.setPerson_name("孙世禄");
		model.setGender("男");
		model.setBirthday("2012-12-12");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		model.setEntryTime(ts);
		model.setDepartment_code("软件销售021");
		update(model);
	}
	
	
	public String update(EmployeeModel model){ //
		String sql = "Update information_manage.person set person_name=?,gender=?,birthday=?,entryTime=?,department_code=? where person_code=9526;";
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, model.getPerson_name());
			ps.setString(2, model.getGender());
			ps.setString(3, model.getBirthday());
			ps.setString(5, model.getDepartment_code());
			ps.setTimestamp(4,model.getEntryTime());
			return ps.executeUpdate() + "";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps, null);
		}
		return null;
	}
	
	public void testSelect() {
		EmployeeDao ed = new EmployeeDao();
		EmployeeModel model = new EmployeeModel();
		model.getPerson_name();
		select(model);
		System.out.println(select(model));
	}
	
	private List<EmployeeModel> select(EmployeeModel model) {
		StringBuffer sql =new StringBuffer("select");
		sql.append(" id,person_code,person_name,gender,birthday,entryTime,tel,department_code");
		sql.append(" from information_manage.person where 1=1 ");
		List<Object> list = appendWhere(sql,model);
		List<EmployeeModel> result = new ArrayList<>();	
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Connection con = JDBCUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql.toString());
			for(int i =0;i<list.size();i++){
				ps.setObject(i+1,list.get(i));
			}
			rs = ps.executeQuery();
			while(rs.next()){
				EmployeeModel m = new EmployeeModel();
				m.setId(rs.getInt("id"));
				m.setPerson_code(rs.getString("person_code"));
				m.setPerson_name(rs.getString("person_name"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));
				m.setDepartment_code("department_code");
				result.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, null);
		}
		return result;
		
	}

	private List<Object> appendWhere(StringBuffer sql, EmployeeModel model) {
		List<Object> list = new ArrayList<>();
		Integer id = model.getId();
		if(id!=null){
			sql.append(" and id = ? ");
			list.add(id);
		}
		String person_code =model.getPerson_code();
		if(person_code!=null&&!person_code.trim().isEmpty()){
			sql.append(" and person_code like ? ");
			list.add(person_code);
		}
		String person_name =model.getPerson_name();
		if(person_name!=null&&!person_name.trim().isEmpty()){
			sql.append(" and person_name like ? ");
			list.add(person_name);
		}
		String gender =model.getGender();
		if(gender!=null&&!gender.trim().isEmpty()){
			sql.append(" and gender like ? ");
			list.add(gender);
		}
		String birthday =model.getBirthday();
		if(birthday!=null&&!birthday.trim().isEmpty()){
			sql.append(" and birthday like ? ");
			list.add(birthday);
		}
		String tel =model.getTel();
		if(tel!=null&&!tel.trim().isEmpty()){
			sql.append(" and tel like ? ");
			list.add(tel);
		}
		String department_code =model.getDepartment_code();
		if(department_code!=null&&!department_code.trim().isEmpty()){
			sql.append(" and department_code like ? ");
			list.add(department_code);
		}
		Timestamp entryTime =model.getEntryTime();
		if(entryTime!=null){
			sql.append(" and entryTime like ? ");
			list.add(entryTime);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp begin = model.getTimeBegin();
		if(begin == null){
			try {
				Date d = sdf.parse("1994-02-01 12:00:00" );
				begin = new Timestamp(d.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Timestamp end = model.getTimeEnd();
		if(end == null){
			try {
				Date d = sdf.parse("2019-02-01 11:25:11");
				end = new Timestamp(d.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		sql.append(" and entryTime between ? and ? ");
		list.add(begin);
		list.add(end);
		return list;
	}
	

}
