package com.deimos;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DataBaseLifeCycle implements QuarkusTestResourceLifecycleManager {
	
	private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql/mysql-server:8.0");

	@Override
	public Map<String, String> start() {
		MYSQL.start();
		Map<String, String> propriedades = new HashMap<>();
		propriedades.put("quarkus.datasource.jdbc.url", MYSQL.getJdbcUrl());
		propriedades.put("quarkus.datasource.username", MYSQL.getUsername());
		propriedades.put("quarkus.datasource.password", MYSQL.getPassword());
		return propriedades ;
	}

	@Override
	public void stop() {
		if(MYSQL != null) {
			MYSQL.stop();
		}

	}

}
