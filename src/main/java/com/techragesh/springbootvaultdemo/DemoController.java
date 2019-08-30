package com.techragesh.springbootvaultdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class DemoController {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/demo")
    public String getConnection() throws SQLException {
        return username + " and " + password + " from vault and connected to  database " +  dataSource.getConnection();
    }

}
