package com.drekyyy.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    public List<Movie> getAll(){
        return movieRepository.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") int id){
        return movieRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Movie> movies){
        return movieRepository.save(movies);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Movie updatedMovie){
        Movie movie=movieRepository.getById(id);

        if (movie != null){
            // w realnym projekcie zwrocic realne kody bledu, 200=ok, 404 not found
            movie.setName(updatedMovie.getName());
            movie.setRating(updatedMovie.getRating());

            return movieRepository.update(movie);
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Movie updatedMovie){
        Movie movie=movieRepository.getById(id);

        if (movie != null){
            if (updatedMovie.getName()!= null) movie.setName(updatedMovie.getName());
            if (updatedMovie.getRating()>0) movie.setRating(updatedMovie.getRating());

            return movieRepository.update(movie);
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){ // @PathVariable = zmienna w adresie
    return movieRepository.delete(id);
    }
}
