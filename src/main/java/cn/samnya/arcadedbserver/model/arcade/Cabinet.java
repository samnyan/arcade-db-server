package cn.samnya.arcadedbserver.model.arcade;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * This is the class contain the information about the actual cabinet running in a arcade.
 * Containing the software and hardware version as well as price
 *
 * @author sam_nya (samnya@outlook.com)
 */
@Entity
public class Cabinet implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;

    private String remark;

    private Integer price;

    @Column( name = "unit_condition" )
    private Condition condition;

    private LocalDateTime updateTime;

    @Column(length = 65535, columnDefinition = "TEXT")
    @Type(type = "text")
    private String description;

    public Cabinet() {
    }

    public Cabinet(Location location, Game game, Hardware hardware, String remark, Integer price, Condition condition, LocalDateTime updateTime, String description) {
        this.location = location;
        this.game = game;
        this.hardware = hardware;
        this.remark = remark;
        this.price = price;
        this.condition = condition;
        this.updateTime = updateTime;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
