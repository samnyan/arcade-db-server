package cn.samnya.arcadedbserver.model.arcade;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Entity
public class Company {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String homePage;

    @Size(max = 200)
    private String imageUrl;

    @ManyToMany(mappedBy = "companies")
    private Set<Game> games = new HashSet<>();

    @ManyToMany(mappedBy = "companies")
    private List<Series> series = new ArrayList<>();

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    public Company() {
    }

    public Company(String name, String homePage, String imageUrl, Set<Game> games, List<Series> series, String description) {
        this.name = name;
        this.homePage = homePage;
        this.imageUrl = imageUrl;
        this.games = games;
        this.series = series;
        this.description = description;
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

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
