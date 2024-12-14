package com.movie_API.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @NotBlank(message = "Please provide movie's title !")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "Please provide movie's director !")
    @Column(nullable = false)
    private String director;

    @NotBlank(message = "Please provide movie's studio !")
    @Column(nullable = false)
    private String studio;

    @NotBlank(message = "Please provide movie's poster !")
    @Column(nullable = false)
    private String poster;

    @Column(nullable = false)
    private Integer releaseYear;

    @ElementCollection // ánh xạ các giá trị đơn giản mà ko phải tạo ra Entity
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCasts;


}
