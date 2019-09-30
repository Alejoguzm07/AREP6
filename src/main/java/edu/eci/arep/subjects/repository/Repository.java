package edu.eci.arep.subjects.repository;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;

import edu.eci.arep.subjects.model.Subject;

@Service
public interface Repository{
    public List<Subject> findAll() throws SQLException ;  
}