package com.MusicReviews.music.Domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long Id;
    private String title;
    private String director;


    @ManyToMany
    @JoinTable(name = "user_movie",joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<User> users = new HashSet<>();

    public Movie() {
    }

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (Id != null ? !Id.equals(movie.Id) : movie.Id != null) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return director != null ? director.equals(movie.director) : movie.director == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }
}
