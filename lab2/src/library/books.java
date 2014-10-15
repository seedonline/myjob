package library;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
inininini
public class books extends ActionSupport {
	private String authorname;
	public String AuthorID;
	public String[] Authorbooks = new String[100];
	public String[] ISBN = new String[100];
	public String[] Authors = new String[10];
	public int booknum;

	public String getName() {
		return authorname;
	}

	public void setName(String authorname) {
		this.authorname = authorname;
	}

	public String execute() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "narc0912";

		booknum = 0;
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			statement.executeQuery("use bookDB");
			ResultSet rs = statement.executeQuery("select * from author");
			String name = null;
			// System.out.println(authorname);

			while (rs.next()) {
				name = rs.getString("Name");
				// System.out.println(name);
				// name = new String(name.getBytes("ISO-8859-1"), "utf-8");
				if (name.equals(authorname)) {
					AuthorID = rs.getString("AuthorID");
					// System.out.println(AuthorID);
				}

			}

			ResultSet rs2 = statement.executeQuery("select * from book");
			name = null;
			while (rs2.next()) {
				name = rs2.getString("AuthorID");
				//System.out.println("AuthorsID"+AuthorID);
				name = new String(name.getBytes("ISO-8859-1"), "GB2312");
				Authors = name.split(";");
				for (int i = 0; i < Authors.length; i++) {
					//System.out.println("Authors"+Authors[i]);
					if (AuthorID.equals(Authors[i])) {
						Authorbooks[booknum] = rs2.getString("Title");
						ISBN[booknum] = rs2.getString("ISBN");
						booknum += 1;
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
		return SUCCESS;
	}

}
