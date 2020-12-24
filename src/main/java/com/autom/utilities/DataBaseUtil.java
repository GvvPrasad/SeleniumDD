package com.autom.utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.autom.base.Base;
import com.autom.init.ObjectRespo;

public class DataBaseUtil extends Base{

	public static void bdConnect() throws ClassNotFoundException, SQLException {
		//Load mysql jdbc driver		
		Class.forName("com.mysql.jdbc.Driver");
		ObjectRespo.con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		ObjectRespo.stmt = ObjectRespo.con.createStatement();

	}

	public static void dbRunQuery(String query) throws SQLException {
		ObjectRespo.dbRes = ObjectRespo.stmt.executeQuery(query);
	}

	public static void dbClose() {
		if (ObjectRespo.dbRes != null) {
			try {
				ObjectRespo.dbRes.close();
			} catch (Exception e) {
			}
		}

		if (ObjectRespo.stmt != null) {
			try {
				ObjectRespo.stmt.close();
			} catch (Exception e) {
			}
		}

		if (ObjectRespo.con != null) {
			try {
				ObjectRespo.con.close();
			} catch (Exception e) {
			}
		}
	}
}