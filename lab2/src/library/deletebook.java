package library;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
aklsdffdasd
public class deletebook extends ActionSupport{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String execute() {
		System.out.println("delete from book where ISBN="+name);
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "narc0912";
		//int i=name.indexOf("/");
		//name=name.substring(0, i);
		System.out.println(name);
		Connection conn = null;
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use bookDB");
			statement.execute("delete from book where ISBN="+name);
			System.out.println("delete from book where ISBN="+name);
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
		
	}
}
