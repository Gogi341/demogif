package com.mg.gifdemo.repository;

import com.mg.gifdemo.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true),
            new Gif("ben-and-mike", "mika", true),
            new Gif("book-dominos", "mem", false),
            new Gif("compiler-bot", "bot", true),
            new Gif("cowboy-coder", "mem", false),
            new Gif("infinite-andrew", "andrew", true)
    );

    public static List<Gif> getGifs() {
        return ALL_GIFS;
    }

    public static List<Gif> getFavoriteGifs() {
        List<Gif> favorites = new ArrayList<>();
        for (int i = 0; i< ALL_GIFS.size(); i++){
            if (ALL_GIFS.get(i).getFavorite()){
                favorites.add(ALL_GIFS.get(i));
            }
        }
        return favorites;
    }

    public Gif getGifByName (String name){
        for (Gif g: ALL_GIFS) {
            if (g.getName().equals(name)) {
                return g;
            }
        }
        return null;
    }
}