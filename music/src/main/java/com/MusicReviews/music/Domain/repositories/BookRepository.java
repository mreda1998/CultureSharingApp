package com.MusicReviews.music.Domain.repositories;

import com.MusicReviews.music.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

}
