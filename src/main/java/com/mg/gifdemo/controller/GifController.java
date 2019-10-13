package com.mg.gifdemo.controller;


import com.mg.gifdemo.model.Gif;
import com.mg.gifdemo.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.mg.gifdemo.repository.GifRepository.*;

@Controller
public class GifController {


    @Autowired // wstrzykiwanie zależności
    GifRepository gifRepository;

    @GetMapping("/") // "/" oznacza, że jest stroną główną

    public String listGifsHome(ModelMap modelMap){ //"ModelMap modelMap" używamy by powiązać frontend z backendem
        //1. Wyciąganie gifów

//        List<Gif> gifList = getAllGifs();
        List<Gif> gifList = gifRepository.getGifs();

        //2. Przekazywanie gifa do View
        modelMap.put("gifs", gifList); // tu dokonaliśmy mapowania, na frontendzie szukamy $ - on zaznacza pobierane dane z BackEnd, dlatego wpisujemy "gifs" do mapy


        //3. Zwracanie nazwy widoku
        return "home";
    }

//    @ResponseBody
//    @GetMapping("/test")
//    public String listGifs() {
//        return getGifs().toString();
//    }
//
//    @ResponseBody
//    @GetMapping("/test1")
//    public String listMikaGifs() {
//
//        List<Gif> allGifs = getGifs();
//
//        for (Gif g : allGifs) {
//            if (g.getAuthor().equals("mika")) {
//                return g.toString();
//            }
//        }
//        return null;
//    }
//
//    @ResponseBody
//    @GetMapping("/test2")
//    public String listOtherThanFavorite() {
//
//        List<Gif> allGifs = getGifs();
//
//        List<Gif> unfavoriteGifs = new ArrayList<>();
//
//        for (Gif g : allGifs) {
//            if (!g.getFavorite()) {
//                unfavoriteGifs.add(g);
//            }
//        }
//        return unfavoriteGifs.toString();
//    }
}
