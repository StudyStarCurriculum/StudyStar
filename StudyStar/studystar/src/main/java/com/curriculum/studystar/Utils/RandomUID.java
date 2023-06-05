package com.curriculum.studystar.Utils;

import java.util.UUID;

public class RandomUID {
    public static String getRandomUID(){
        String[] uuid = UUID.randomUUID().toString().split("-");
        return uuid[0];
    }
}

