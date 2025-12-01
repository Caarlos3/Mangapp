package com.caarlos.mangalibrary.model;

import java.util.List;

public class Manga {
    private int malId;
    private String title;
    private List<String> authors;
    private List<String> genres;
    private String synopsis;
    private Integer publishedYear;
    private Double rating;
    private MangaStatus status;

    public Manga(){
    }
    public Manga(int malId, String title, List<String> authors, List<String> genres, String synopsis, Integer publishedYear, Double rating, MangaStatus status) {
        this.malId = malId;
        this.title = title;
        this.authors = authors;
        this.genres = genres;
        this.synopsis = synopsis;
        this.publishedYear = publishedYear;
        this.rating = rating;
        this.status = status;
    }

    public int getMalId() {
        return malId;
    }
    public void setMalId(int malId) {
        this.malId = malId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public MangaStatus getStatus() {
        return status;
    }

    public void setStatus(MangaStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "malId=" + malId +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                ", rating =" + rating +
                ", status=" + status +
                '}';
    }
}
