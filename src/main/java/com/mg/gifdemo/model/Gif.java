package com.mg.gifdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class Gif {
    @Getter
    private String name;

    @Getter
    private String author;

    @Getter
    private Boolean favorite;

//    @Override
//    public String toString() {
//        return "name='" + name + '\'' +
//                ", autor='" + author + '\'' +
//                ", favorite=" + favorite;
//    }
}
