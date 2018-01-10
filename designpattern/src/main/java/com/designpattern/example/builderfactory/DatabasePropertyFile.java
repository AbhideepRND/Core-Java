package com.designpattern.example.builderfactory;


/*
 * Represent can be change but the structure is same
 */
public class DatabasePropertyFile {

	private String connectionUrl;
	private String database;
	private String port;
	private String username;
	private String password;
	public static enum DatabaseType{
		mysql,oracle;
	};
	
	private DatabaseType dataType;
	
	
	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDataType(DatabaseType dataType) {
		this.dataType = dataType;
	}

	public String getDatabaseUrl(){
		
			if(DatabaseType.mysql.equals(dataType)){
				return getMySqlUrl();
			}else{
				return getOracleUrl();
			}
	}
	
	private String getMySqlUrl() {
		/* jdbc:mysql://localhost:3306/test */

		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("jdbc:mysql");
		stringBuilder.append(":");
		stringBuilder.append(connectionUrl);
		stringBuilder.append(":");
		stringBuilder.append(port);
		stringBuilder.append("/");
		stringBuilder.append(database);
		return stringBuilder.toString();

	}
	
	private String getOracleUrl() {
		/*jdbc:oracle:thin:@localhost:1521:orcl*/
		
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("jdbc:oracle:thin");
		stringBuilder.append(":");
		stringBuilder.append(connectionUrl);
		stringBuilder.append(":");
		stringBuilder.append(port);
		stringBuilder.append(":");
		stringBuilder.append(database);
		return stringBuilder.toString();
		
	}
}
