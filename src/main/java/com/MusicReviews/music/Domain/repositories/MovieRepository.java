package com.MusicReviews.music.Domain.repositories;

import com.MusicReviews.music.Domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,Long> {

}
