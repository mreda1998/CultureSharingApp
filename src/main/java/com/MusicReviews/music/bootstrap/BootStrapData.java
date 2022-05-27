package com.MusicReviews.music.bootstrap;

import com.MusicReviews.music.Domain.Album;
import com.MusicReviews.music.Domain.Movie;
import com.MusicReviews.music.Domain.User;
import com.MusicReviews.music.Domain.repositories.AlbumRepository;

import com.MusicReviews.music.Domain.repositories.MovieRepository;
import com.MusicReviews.music.Domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AlbumRepository albumRepository;
    private final MovieRepository movieRepository;

    public BootStrapData(UserRepository userRepository, AlbumRepository albumRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.albumRepository = albumRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setName("reda");
        user.setFavoriteMovie("Whiplash");
        user.setLastMovie("The Northman");
        user.setFavoriteAlbum("Ipseite");
        user.setLastAlbum("Mr Morale");

        userRepository.save(user);
        System.out.println("Publisher count" + userRepository.count());

        Album ipseite = new Album("Ipseite","Damso",new Date(2017, Calendar.APRIL,28));
        Album mrMorale = new Album("Mr Morale", "Kendrick",new Date(2022,Calendar.MAY,13));
        ipseite.getUsers().add(user);
        user.getAlbums().add(ipseite);
        user.getAlbums().add(mrMorale);

        Movie whiplash = new Movie("Whiplash","Damien Chazelle");
        Movie northman = new Movie("The Northman","Robert Eggers");

        ipseite.getUsers().add(user);
        user.getMovies().add(whiplash);
        user.getMovies().add(northman);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of movies: " + movieRepository.count());
        System.out.println("Publisher number of movies :"+ user.getMovies().size());

    }
}
