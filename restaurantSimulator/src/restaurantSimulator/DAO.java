package restaurantSimulator;

import java.util.*;
import java.sql.*;

public class DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private String JDBC_DRIVER = ""; // 고치자
	private String DB_URL = ""; // 고치자
	private String DB_USER = ""; // 고치자
	private String DB_PASSWORD = ""; //고치자
	
	private DAO() {
		try {
			Class.forName(this.JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static class Singleton{
		private static final DAO instance = new DAO();
	}
	
	public static DAO getInstance() {
		return Singleton.instance;
	}
	
	//catch문이 부실하다 고치자
	public boolean setData(String sqlQuery, List values) throws SQLException{
		int numberOfQm = countQm(sqlQuery);
		if(numberOfQm != values.size()) {
			System.out.println("물음표 갯수랑 속성값 갯수가 달라");
			return false;
		}
		conn = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
		pstmt = conn.prepareStatement(sqlQuery);
		for(int count = 0; count < numberOfQm ; count++) {
			pstmt.setString(count + 1, values.get(count).toString());
		}
		pstmt.executeUpdate();
		return true;
	}
	
	public List <Map<String,Object>> getData(String sqlQuery){
		List<Map<String,Object>> values = new ArrayList();
		return getData(sqlQuery,values);
	}
	//catch문이 부실하다 고치자
	public List <Map<String,Object>> getData(String sqlQuery, List values){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		int numberOfQm = countQm(sqlQuery);
		if(numberOfQm != values.size()) {
			System.out.println("물음표 갯수랑 속성값 갯수가 달라");
			return null;
		}
		try {
			conn = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
			pstmt = conn.prepareStatement(sqlQuery);
			for(int count = 0; count < numberOfQm; count++) {
				pstmt.setString(count + 1,  values.get(count).toString());
			}
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				ResultSetMetaData metadata = rs.getMetaData();
				Map<String, Object> index = new HashMap<String,Object>();
				for(int count = 0; count < metadata.getColumnCount(); count++) {
					index.put(metadata.getColumnLabel(count+1).toString(), rs.getObject(metadata.getColumnLabel(count+1).toString()));
				}
				result.add(index);
			}
		}catch(SQLException SQLe) {
			throw new RuntimeException(SQLe);
			//고치자
		}finally {
			try{
				pstmt.clearParameters();
				pstmt.close();
				conn.close();
			}catch(SQLException SQLe) {
				throw new RuntimeException(SQLe);
			}
		}
		return result;
	}
	public void commit() throws SQLException{
		conn.commit();
		try {
			pstmt.clearParameters();
			pstmt.close();
			conn.close();
		}catch(SQLException SQLe) {
			throw new RuntimeException(SQLe);
		}
	}
	public void rollback() {
		try {
			conn.rollback();
			pstmt.clearParameters();
			pstmt.close();
			conn.close();
		}catch(SQLException SQLe) {
			throw new RuntimeException(SQLe);
		}
	}
	private int countQm(String clone) {
		int numberOfQm = 0;
		int length = clone.length();
		for(int count = 0; count < length; count++) 
			if(clone.charAt(count) == '?') 
				numberOfQm++;
		return numberOfQm;
	}
	
	/*응용해서 트랜잭션을 만들어보자*/
}