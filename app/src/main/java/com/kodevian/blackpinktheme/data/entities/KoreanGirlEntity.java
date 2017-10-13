package com.kodevian.blackpinktheme.data.entities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by Junior Quevedo on 06/10/17.
 */

public final class KoreanGirlEntity implements Serializable {


    @NonNull
    private String id;
    @Nullable
    private String first_name;
    @Nullable
    private String last_name;
    @Nullable
    private String image;
    @Nullable
    private int age;


    /**
     * Use this constructor to create girl korean model
     *
     * @param first_name  Firstname of a girl korean model
     * @param last_name  Lastname of  a girl korean model
     * @param image  url from image of a girl korean model
     * @param age  of a girl korean model
     */
    public KoreanGirlEntity(String first_name, String last_name, String image, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.image = image;
        this.age = age;
    }

    public KoreanGirlEntity(String itemId, String firstName, String lastName, String image, int age) {
        this.id = itemId;
        this.first_name = firstName;
        this.last_name = lastName;
        this.image = image;
        this.age = age;
    }


    @NonNull
    public String getId() {
        return id;
    }

    @Nullable
    public String getFirst_name() {
        return first_name;
    }



    @Nullable
    public String getLast_name() {
        return last_name;
    }


    @Nullable
    public String getImage() {
        return image;
    }


    @Nullable
    public String getAge() {

        return age > 16 ? age + " años" : "Menor de edad";
    }


    @Nullable
    public String getFullName() {
        return first_name + " " + last_name;
    }


}
