package cn.samnya.arcadedbserver.model.arcade;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Entity
public class Hardware implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String model;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Size(max = 200)
    private String imageUrl;

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    @ManyToMany(mappedBy = "hardware")
    private List<Game> games = new ArrayList<>();

    @ManyToMany(mappedBy = "hardware")
    private List<Series> series = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hardware")
    private List<Cabinet> cabinets = new ArrayList<>();

    public Hardware() {
    }

    public Hardware(String name, String model, LocalDate releaseDate, String imageUrl, String description, List<Game> games, List<Series> series) {
        this.name = name;
        this.model = model;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
        this.description = description;
        this.games = games;
        this.series = series;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }
}
