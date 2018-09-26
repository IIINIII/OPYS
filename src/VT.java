import java.sql.*;

import javax.swing.JOptionPane;

public class VT {
	
	// Degiskenler
	private static String dbServer;
	private static String dataBase;
	private static String dbUser;
	private static String dbPassword;
	public static Statement dbStatement; // ifade
	public static Connection dbConnection; // baglanti
	
	// Metotlar
	public static void setInfo(String dbServer,String dataBase,String dbUser,String dbPassword)
	{
		VT.dbServer=dbServer;
		VT.dataBase=dataBase;
		VT.dbUser=dbUser;
		VT.dbPassword=dbPassword;
	}
	
	public static boolean startConnection()
	{
		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://"+dbServer+"/"+dataBase+"?useUnicode=true&characterEncoding=UTF-8&" +
			        "user="+dbUser+"&password="+dbPassword);
			dbStatement=dbConnection.createStatement();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(Login.ekran.getContentPane(), "Bağlantı Oluşturulamadı!", "Veri Tabanı", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
			return false; // Baglanti olusmadi
		}
		return true;
	}
	
	public static ResultSet veriAl(String query)
	{
		try {
			return dbStatement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ResultSet veriAl1(String query)
	{
		try {
			Statement st = dbConnection.createStatement();
			return st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int veriEkle(String query)
	{
		query = query.replaceAll("Seçiniz", "");
		try {
			return dbStatement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}
