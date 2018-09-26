
public class DBUser {
	
	String name;
	String surname;
	String username;
	String password;
	String authority;
	
	public DBUser(String[] data) {
		username = data[0];
		name = data[1];
		surname = data[2];
		password = data[3];
		authority = data[4];
	}

}
