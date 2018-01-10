package com.designpattern.example.builderfactory;

import com.designpattern.example.builderfactory.pattern.DatabaseBuilder;

public class DatabaseProp {
	private DatabaseBuilder databuilder;

	public void setDatabuilder(DatabaseBuilder databuilder) {
		this.databuilder = databuilder;
	}

	public DatabaseBuilder getDatabuilder() {
		return databuilder;
	}

	public void createDatabase() {

	}
}
