package cn.samnya.arcadedbserver.model.arcade;

import cn.samnya.arcadedbserver.model.metadata.Release;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String imageUrl;

    @NotNull
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "game_company_mapping",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private Series series;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "game_hardware_mapping",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "hardware_id")
    )
    private List<Hardware> hardware = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game")
    private List<Cabinet> cabinets = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "game")
    private List<Release> releases = new ArrayList<>();

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    public Game() {
    }

    public Game(@NotBlank @Size(max = 200) String name, @Size(max = 200) String imageUrl, @NotNull Genre genre, Series series, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.genre = genre;
        this.series = series;
        this.description = description;
    }

    public Game(@NotBlank @Size(max = 200) String name, @Size(max = 200) String imageUrl, @NotNull Genre genre, List<Company> companies, Series series, List<Hardware> hardware, List<Cabinet> cabinets, List<Release> releases, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.genre = genre;
        this.companies = companies;
        this.series = series;
        this.hardware = hardware;
        this.cabinets = cabinets;
        this.releases = releases;
        this.description = description;
    }

    public List<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public List<Hardware> getHardware() {
        return hardware;
    }

    public void setHardware(List<Hardware> hardware) {
        this.hardware = hardware;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
