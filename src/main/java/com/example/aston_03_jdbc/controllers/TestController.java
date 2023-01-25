package com.example.aston_03_jdbc.controllers;

import com.example.aston_03_jdbc.config.JdbcConnection;
import com.example.aston_03_jdbc.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@RestController
public class TestController {
    private final Optional<Connection> connection;
    private Statement stmt;

    public TestController(Optional<Connection> connection) {
        this.connection = JdbcConnection.getConnection();
    }


    @PostMapping(value = "/addUserName={name}")
    public ResponseEntity<?> createUser (@PathVariable(name = "name") String name) throws SQLException {
       if (connection.isPresent()) {
           stmt = connection.get().createStatement();
       }

       String psql = "INSERT INTO USERS (name) VALUES ('" + name + "')";
       stmt.executeUpdate(psql);

       return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
