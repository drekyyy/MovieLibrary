package com.drekyyy.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<Movie> getAll() {
        return jdbcTemplate.query( "Select id, name, rating FROM movie",
               BeanPropertyRowMapper.newInstance(Movie.class));

    }

    public Movie getById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM movie where id = ?",
                BeanPropertyRowMapper.newInstance(Movie.class), id);
    }
}
