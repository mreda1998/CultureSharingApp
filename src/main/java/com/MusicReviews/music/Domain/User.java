package com.MusicReviews.music.Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String favoriteMovie;
    private String LastMovie;
    private Integer LastMovieRating;
    private String favoriteAlbum;
    private String LastAlbum;
    private Integer LastAlbumRating;

    @OneToMany
    @JoinColumn(name = "user_id ")
    private Set<Movie> movies = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "user_id ")
    private Set<Album> albums = new HashSet<>();
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", favoriteMovie='" + favoriteMovie + '\'' +
                ", LastMovie='" + LastMovie + '\'' +
                ", LastMovieRating=" + LastMovieRating +
                ", favoriteAlbum='" + favoriteAlbum + '\'' +
                ", LastAlbum='" + LastAlbum + '\'' +
                ", LastAlbumRating=" + LastAlbumRating +
                ", movies=" + movies +
                ", albums=" + albums +
                '}';
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public User(Long id, String name, String favoriteMovie, String favoriteAlbum) {
        this.id = id;
        this.name = name;
        this.favoriteMovie = favoriteMovie;
        this.favoriteAlbum = favoriteAlbum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(String favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }

    public String getLastMovie() {
        return LastMovie;
    }

    public void setLastMovie(String lastMovie) {
        LastMovie = lastMovie;
    }

    public Integer getLastMovieRating() {
        return LastMovieRating;
    }

    public void setLastMovieRating(Integer lastMovieRating) {
        LastMovieRating = lastMovieRating;
    }

    public String getFavoriteAlbum() {
        return favoriteAlbum;
    }

    public void setFavoriteAlbum(String favoriteAlbum) {
        this.favoriteAlbum = favoriteAlbum;
    }

    public String getLastAlbum() {
        return LastAlbum;
    }

    public void setLastAlbum(String lastAlbum) {
        LastAlbum = lastAlbum;
    }

    public Integer getLastAlbumRating() {
        return LastAlbumRating;
    }

    public void setLastAlbumRating(Integer lastAlbumRating) {
        LastAlbumRating = lastAlbumRating;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

}
