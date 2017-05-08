package week8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DB_Connect {
	private String username="jisung";
	private String password="0920";
	private static Connection dbTest;
	DB_Connect(){
		connectDB();
	}
	
	private void connectDB(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE"
					, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void query1() throws SQLException{
		String sqlStr = "SELECT maker,model,price FROM pc natural join product"
				+ " where cd='8x' and ram>=24";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		System.out.println("q1\nmaker/model/price");
		while(rs.next())
			System.out.println(rs.getString("maker")+"/"+rs.getString("model")+"/"+rs.getString("price")); 
		rs.close(); 
		stmt.close();
	}
	public void query2() throws SQLException{
		String sqlStr = "SELECT sum(price) FROM laptop natural join product"
				+ " where (maker='D' or maker = 'G') and screen>11";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
	
		System.out.println("q2\nmaker/model/price");
		while(rs.next())
			System.out.println(rs.getString("sum(price)")); 
		rs.close(); 
		stmt.close();
	}
	public void query3() throws SQLException{
		String sqlStr = "SELECT count(model) FROM( (select model from laptop "
				+ "where speed>130) union (select model from pc where hd>2.4))";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		System.out.println("q3\ncount(model)");
		while(rs.next())
			System.out.println(rs.getString("count(model)")); 
		rs.close(); 
		stmt.close();
	}
	public void query4() throws SQLException{
		String sqlStr = "SELECT model, price FROM pc"
				+ " where cd='8x' and speed>some(select speed from laptop)";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		System.out.println("q4\nmodel / price");
		while(rs.next())
			System.out.println(rs.getString("model")+"/"+rs.getString("price")); 
		rs.close(); 
		stmt.close();
	}
	public void query5() throws SQLException{
		String sqlStr = "SELECT maker,speed  "
				+ "FROM laptop join product on laptop.model=product.model "
				+ " where hd>=1";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		System.out.println("q5\nmaker/speed");
		while(rs.next())
			System.out.println(rs.getString("maker")+"/"+rs.getString("speed")); 
		rs.close(); 
		stmt.close();
	}
	public void query6() throws SQLException{
		String sqlStr = "(SELECT model FROM laptop where speed>some(select speed from laptop where model = '2005')) "
				+ "union(select model from pc where speed>some"
				+ "(select speed from laptop where model = '2005'))";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		ResultSet rs = stmt.executeQuery();
		System.out.println("q6\nmodel");
		while(rs.next())
			System.out.println(rs.getString("model")); 
		rs.close(); 
		stmt.close();
	}
	public void query7() throws SQLException{
		String sqlStr = "SELECT printer.model,printer.type,price from printer"
				+ " join product on(printer.model=product.model)"
				+ " where maker = 'D'and color = 'true'";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr); 
		System.out.println("q7\nmodel/type/price");
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
			System.out.println(rs.getString("model")+"/"+rs.getString("type")+"/"+rs.getString("price")); 
		rs.close(); 
		stmt.close();
	}
	

}
