package com.MusicReviews.music.Domain.repositories;

import com.MusicReviews.music.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
