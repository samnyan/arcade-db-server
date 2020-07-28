package cn.samnya.arcadedbserver.model.arcade;


import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Entity
public class Series implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank
    private String name;

    private String imageUrl;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "series_company_mapping",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "series")
    private List<Game> games = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "series_hardware_mapping",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "hardware_id")
    )
    private List<Hardware> hardware = new ArrayList<>();

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate firstReleaseDate;

    public Series() {
    }

    public Series(String name, String imageUrl, List<Company> companies, List<Game> games, List<Hardware> hardwares, String description, LocalDate firstReleaseDate) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.companies = companies;
        this.games = games;
        this.hardware = hardwares;
        this.description = description;
        this.firstReleaseDate = firstReleaseDate;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Hardware> getHardware() {
        return hardware;
    }

    public void setHardware(List<Hardware> hardware) {
        this.hardware = hardware;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public void setFirstReleaseDate(LocalDate firstReleaseDate) {
        this.firstReleaseDate = firstReleaseDate;
    }
}
