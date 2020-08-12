package fr.easydog.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

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

    private boolean isLiked;

    @Ignore
    public Dog(){}

    public Dog(int id, String name, String description, Date date, Race race) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.race = race;
    }

    @Ignore
    protected Dog(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
    }

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

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeValue(race);
        parcel.writeValue(date);
    }
}
