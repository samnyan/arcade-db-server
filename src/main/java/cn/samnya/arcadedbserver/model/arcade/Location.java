package cn.samnya.arcadedbserver.model.arcade;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Entity
public class Location {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private LocationStatus status = LocationStatus.OPEN;

    @NotBlank
    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String imageUrl;

    private double longitude;

    private double latitude;

    @NotBlank
    @Size(max = 200)
    private String address;

    @Size(max = 200)
    private String website;

    @Size(max = 200)
    private String contact;

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String workTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "location")
    private List<Cabinet> cabinets = new ArrayList<>();

    public Location() {
    }

    public Location(LocationStatus status, String name, String imageUrl, double longitude, double latitude, String address, String website, String contact, String description, String workTime, List<Cabinet> cabinets) {
        this.status = status;
        this.name = name;
        this.imageUrl = imageUrl;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.website = website;
        this.contact = contact;
        this.description = description;
        this.workTime = workTime;
        this.cabinets = cabinets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocationStatus getStatus() {
        return status;
    }

    public void setStatus(LocationStatus status) {
        this.status = status;
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public List<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }
}
