package com.mvc.theam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.theam.model.Employee;
import com.mvc.theam.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAOi {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private int id;
	private int result;
	private Employee e;
	private List<Employee> ls;

	@Override
	public int getEmpId() {
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select max(id) id from employee");
			rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("id");
				id++;
			} else {
				id = 1;
			}
			con.close();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int addEmployee(Employee e) {
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("insert into employee(id,name,email,phone,address,gender,ms,doj,sports,music,traveling,skills,image) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setLong(4, e.getPhone());
			ps.setString(5, e.getAddress());
			ps.setString(6, e.getGender());
			ps.setString(7, e.getMs());
			ps.setDate(8, e.getDoj());
			ps.setString(9, e.getSports());
			ps.setString(10, e.getMusic());
			ps.setString(11, e.getTraveling());
			ps.setString(12, e.getSkills());
			ps.setString(13, e.getImage());
			result = ps.executeUpdate();
			con.close();
			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Employee> getEmployee() {
		try {
			ls = new ArrayList<>();
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select * from employee");
			rs = ps.executeQuery();
			while(rs.next()){
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getLong("phone"));
//				e.setAddress(rs.getString("address"));
//				e.setGender(rs.getString("gender"));
//				e.setMs(rs.getString("ms"));
//				e.setDoj(rs.getDate("doj"));
//				e.setSports(rs.getString("sports"));
//				e.setMusic(rs.getString("music"));
//				e.setTraveling(rs.getString("traveling"));
//				e.setSkills(rs.getString("skills"));
//				e.setImage(rs.getString("image"));
				ls.add(e);
			}
			con.close();
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Employee viewEmployee(int hid) {
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("select * from employee where id = ?");
			ps.setInt(1, hid);
			rs = ps.executeQuery();
			while(rs.next()){
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getLong("phone"));
				e.setAddress(rs.getString("address"));
				e.setGender(rs.getString("gender"));
				e.setMs(rs.getString("ms"));
				e.setDoj(rs.getDate("doj"));
				e.setSports(rs.getString("sports"));
				e.setMusic(rs.getString("music"));
				e.setTraveling(rs.getString("traveling"));
				e.setSkills(rs.getString("skills"));
				e.setImage(rs.getString("image"));
			}
			con.close();
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateEmployee(Employee e) {
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("update employee set name=?,email=?,phone=?,address=?,gender=?,ms=?,doj=?,sports=?,music=?,traveling=?,skills=?,image=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setLong(3, e.getPhone());
			ps.setString(4, e.getAddress());
			ps.setString(5, e.getGender());
			ps.setString(6, e.getMs());
			ps.setDate(7, e.getDoj());
			ps.setString(8, e.getSports());
			ps.setString(9, e.getMusic());
			ps.setString(10, e.getTraveling());
			ps.setString(11, e.getSkills());
			ps.setString(12, e.getImage());
			ps.setInt(13, e.getId());
			result = ps.executeUpdate();
			con.close();
			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

	@Override
	public int deleteEmployee(int hid) {
		try {
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement("delete from employee where id=?");
			ps.setInt(1, hid);
			result = ps.executeUpdate();
			con.close();
			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return 0;
		}
	}

}
