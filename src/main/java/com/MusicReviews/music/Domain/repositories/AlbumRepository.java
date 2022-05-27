package com.MusicReviews.music.Domain.repositories;

import com.MusicReviews.music.Domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {

}
