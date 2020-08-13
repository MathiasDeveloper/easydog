package fr.easydog.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * Dog class
 */
@Entity
public class Dog implements Parcelable {

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

    /**
     * boolean isLiked
     */
    private boolean isLiked;

    /**
     * Construct Dog
     */
    @Ignore
    public Dog(){}

    /**
     * Construct dog
     * @param id          => id object
     * @param name        => name of dog
     * @param description => description of dog
     * @param date        => date birthday
     * @param race        => race dog object
     */
    public Dog(int id, String name, String description, Date date, Race race) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.race = race;
    }

    /**
     * Parcel object dog
     * @param in => parcel object
     */
    @Ignore
    protected Dog(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    /**
     * Create parcelable dog
     */
    public static final Creator<Dog> CREATOR = new Creator<Dog>() {
        @Override
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        @Override
        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    /**
     * Get id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter id
     * @param id => id object
     * @return void
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter name of dog
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name dog
     * @param name => name of dog
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description of dog
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description dog
     * @param description => description to dog
     * @return void
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get Date
     * @return Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter date
     * @param date => date birthday
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get object race
     * @return Race
     */
    public Race getRace() {
        return race;
    }

    /**
     * Setter Race
     * @param race => Race object
     * @return void
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Is liked or not
     * @return boolean
     */
    public boolean isLiked() {
        return isLiked;
    }

    /**
     * Setter is liked
     * @param liked => true or false
     * @return void
     */
    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    /**
     * Method to string for dog
     * @return String
     */
    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", race=" + race +
                ", isLiked=" + isLiked +
                '}';
    }

    /**
     * Describe content method Parcelable interface
     * @return int
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Write to parcel Method
     * @param parcel => Parcel object
     * @param i => position
     * @return void
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeValue(race);
        parcel.writeValue(date);
    }
}
