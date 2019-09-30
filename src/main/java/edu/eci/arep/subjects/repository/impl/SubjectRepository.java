package edu.eci.arep.subjects.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.eci.arep.subjects.model.Subject;
import edu.eci.arep.subjects.repository.Repository;


@Component
public class SubjectRepository implements Repository {


	@Autowired
	private DataSource dataSource;

    public List<Subject> findAll() throws SQLException {
       String query = "SELECT * FROM subjects;";
		List<Subject> subjects = new ArrayList<Subject>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                int credits = Integer.parseInt(rs.getString("credits"));
				Subject subject = new Subject(id,name,credits);									
				subjects.add(subject);
			}
			connection.close();
			return subjects;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
    }
}