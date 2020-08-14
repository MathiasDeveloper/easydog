package fr.easydog.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Race class
 */
@Entity
public class Race implements Parcelable {

    /**
     * int id
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    /**
     * Name of race
     * String name
     */
    private String name;

    /**
     * Construct Race
     * @param name => name of race
     */
    @Ignore
    public Race(String name) {
        this.name = name;
    }

    /**
     * Construct Race
     * @param id   => id object
     * @param name => name of race
     */
    public Race(int id, String name) {
        this(name);
        this.id = id;
    }

    protected Race(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Race> CREATOR = new Creator<Race>() {
        @Override
        public Race createFromParcel(Parcel in) {
            return new Race(in);
        }

        @Override
        public Race[] newArray(int size) {
            return new Race[size];
        }
    };

    /**
     * Getter id object
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
     * Getter name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name
     * @param name => name of race
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method tostring
     * @return String
     */
    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
