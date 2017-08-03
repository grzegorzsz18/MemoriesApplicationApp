package com.example.grzegorz.memoriesapplicationapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Grzegorz on 2017-07-31.
 */

public class DiaryService {
    private static ArrayList<DiaryPost> diaryList = new ArrayList<>();

    public static void addSomeData(){
        diaryList.add(new DiaryPost(0,"jan","tytul","text",new Date(System.currentTimeMillis())));
        diaryList.add(new DiaryPost(1,"jan1","tytul","text1",new Date(System.currentTimeMillis())));
        diaryList.add(new DiaryPost(2,"jan2","tytul","text2",new Date(System.currentTimeMillis())));
    }

    public static List<DiaryPost> getAllDiary(){
        addSomeData();
        return diaryList;
    }

    public static DiaryPost getDiaryById(int id){
        return diaryList.get(id);
    }

    public static void removeDiaryById(int id){
        diaryList.get(id).text = "usunieto";
    }

}
