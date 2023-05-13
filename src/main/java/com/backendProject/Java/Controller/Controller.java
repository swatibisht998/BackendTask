package com.backendProject.Java.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendProject.Java.entities.GenreMovie;
import com.backendProject.Java.entities.Movie;
import com.backendProject.Java.entities.MovieRating;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);
    }

    @GetMapping("/longest-duration-movies")
    public List<Movie> getLongestDurationMovies() {
        String sql = "SELECT m.tconst, m.primaryTitle, m.runTimeMinutes, m.genres,m.titleType "
                + "FROM movies m "
                + "ORDER BY m.runTimeMinutes DESC "
                + "LIMIT 10";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class));
    }

    @PostMapping("/new-movie")
    public String saveNewMovie(@RequestBody Movie movie) {
        String sql = "INSERT INTO movies (tconst, primaryTitle, titleType, runTimeMinutes, genres) "
                + "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, movie.getTconst(), movie.getPrimaryTitle(),
                movie.getTitleType(), movie.getRuntimeMinutes(), movie.getGenres());
        return "success";
    }

    @GetMapping("/top-rated-movies")
    public List<MovieRating> getTopRatedMovies() {
        String sql = "SELECT m.tconst, m.primaryTitle, m.genres, r.averageRating "
                + "FROM movies m "
                + "INNER JOIN ratings r ON m.tconst = r.tconst "
                + "WHERE r.averageRating > 6.0 "
                + "ORDER BY r.averageRating DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MovieRating.class));
    }

    @GetMapping("/genre-movies-with-subtotals")
    public List<GenreMovie> getGenreMoviesWithSubtotals() {
        String sql = "SELECT m.genres, m.primaryTitle, SUM(r.numVotes) AS numVotes "
                + "FROM movies m "
                + "INNER JOIN ratings r ON m.tconst = r.tconst "
                + "GROUP BY m.genres, m.primaryTitle "
                + "WITH ROLLUP";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(GenreMovie.class));
    }

    @PostMapping("/update-runtime-minutes")
    public String updateRuntimeMinutes() {
        String sql = "UPDATE movies "
                + "SET runTimeMinutes = CASE "
                + "WHEN genres LIKE '%Documentary%' THEN runTimeMinutes + 15 "
                + "WHEN genres LIKE '%Animation%' THEN runTimeMinutes + 30 "
                + "ELSE runTimeMinutes + 45 "
                + "END";
        jdbcTemplate.update(sql);
        return "success";
    }
}
