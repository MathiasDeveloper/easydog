package fr.easydog.bo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
public class Dog {

    /**
     * int Id
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    /**
     * String name
     */
    private String name;

    /**
     * String description
     */
    private String description;

    /**
     * Date date
     */
    private Date date;

    /**
     * Object race
     * Race race
     */
    private Race race;


    public Dog(int id, String name, String description, Date date, Race race) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @NotNull
    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", race=" + race +
                '}';
    }
}
