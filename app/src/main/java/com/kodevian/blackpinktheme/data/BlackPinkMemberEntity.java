package com.kodevian.blackpinktheme.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior Quevedo on 06/10/17.
 */

public class BlackPinkMemberEntity implements Serializable {


    private String first_name;
    private String last_name;
    private String photo;


    public BlackPinkMemberEntity(String first_name, String last_name, String photo) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.photo = photo;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public static List<BlackPinkMemberEntity> getMockData() {

        List<BlackPinkMemberEntity> blackPinkMemberEntities = new ArrayList<>();


        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Jenni", "Kim", "http://image.en.yibada.com/data/thumbs/full/104663/685/0/0/0/blackpinks-jennie-kim.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Roseanne", "Park", "https://pbs.twimg.com/profile_images/877917193161371654/Zo1YT7Uw_400x400.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Kim", "Jisso", "http://cdn.koreaboo.com/wp-content/uploads/2017/07/jisoo-blackpink9.jpg"));
        blackPinkMemberEntities.add(new BlackPinkMemberEntity("Lalisa", "Manoban", "https://vignette2.wikia.nocookie.net/drama/images/2/20/04f8fdd6ae151455cc8a0745c4836c0d.jpg/revision/latest?cb=20170310160053&path-prefix=es"));

        return blackPinkMemberEntities;

    }

    public String getFullName() {
        return first_name + " " + last_name;
    }
}
