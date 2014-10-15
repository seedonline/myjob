package library;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
git lab 2.1
public class findAuthor extends ActionSupport {
	private String ISBN;
	public String AuthorID;
	public String[] Authors = new String[10];
	public String[] Names = new String[10];
	public String[] Ages = new String[10];
	public String[] Countrys = new String[10];

	public String getName() {
		return ISBN;
	}

	public void setName(String ISBN) {
		this.ISBN = ISBN;
	}

	public String execute() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "narc0912";
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use bookDB");
			ResultSet rs = statement.executeQuery("select * from Book");
			//System.out.println(ISBN);
			String name = null;
			while (rs.next()) {
				name = rs.getString("ISBN");
				// name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				//System.out.println(name);
				//System.out.println(ISBN);
				if (name.equals(ISBN)) {
					AuthorID = rs.getString("AuthorID");
					//System.out.println(AuthorID);
				}
			}
			ResultSet rs2 = statement.executeQuery("select * from Author");
			Authors = AuthorID.split(";");
			//System.out.println("AuthorID"+AuthorID);
			//System.out.println("Authors"+Authors[0]);
			String tmp = null;
			while (rs2.next()) {
				tmp = rs2.getString("AuthorID");
				for(int i=0;i<Authors.length;i++){
					if (tmp.equals(Authors[i])) {
						Names[i] = rs2.getString("Name");
						Ages[i] = rs2.getString("Age");
						Countrys[i] = rs2.getString("Country");
					}
				}
			}
			rs.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}


	}
}
