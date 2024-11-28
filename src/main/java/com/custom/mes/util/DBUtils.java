package com.custom.mes.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBUtils {
	
	public static List<?> executeSqlFile(JdbcTemplate jdbcTemplate, String filePath) {
        try {
            // 파일 읽기
            //File file = new File(DBUtils.class.getResource(filePath).getFile());
        	File file = new File(DBUtils.class.getResource(filePath).getFile());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String sql = reader.lines().collect(Collectors.joining("\n"));
            
            // 쿼리 실행 및 결과 반환
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute SQL file", e);
        }
    }
	
    public static List<?> executeSqlFile(JdbcTemplate jdbcTemplate, String filePath, String factoryCode, String orderNo) {
        try {
            // 파일 읽기
        	File file = new File(DBUtils.class.getResource(filePath).getFile());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String sql = reader.lines().collect(Collectors.joining("\n"));

            // 쿼리 실행 및 결과 반환 (단일 행)
            return jdbcTemplate.queryForList(sql, new Object[]{factoryCode, orderNo});
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute SQL file", e);
        }
    }
}

