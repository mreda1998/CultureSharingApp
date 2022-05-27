package com.MusicReviews.music.Domain.repositories;

import com.MusicReviews.music.Domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
