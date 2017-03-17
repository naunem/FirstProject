package com.example.naunem.firstproject;

import com.example.naunem.firstproject.models.ItemList;
import com.example.naunem.firstproject.models.Title;
import com.example.naunem.firstproject.models.User;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by naunem on 10/03/2017.
 */

public class MockData {
    public static ArrayList<ItemList> getData() {
        ArrayList<ItemList> lists = new ArrayList<>();
        Random random = new Random();
        int image;
        String gender;
        int favorite;
        String name;
        String age;
        for (int i = 0; i < 20; i++) {
            int rand = random.nextInt(20);
            name = "User " + i;
            age = "Age: " + i;
            boolean isFavorite = false;
            if (i % 2 == 0) {
                image = R.drawable.ic_boy;
                gender = "Gender: Male " + i;
            } else {
                image = R.drawable.ic_girl;
                gender = "Gender: Female " + i;
            }
            favorite = R.drawable.ic_star_border;
            if (i == rand || i == 0) {
                lists.add(new Title("Group A"));
            } else if (rand % 4 == 1) {
                lists.add(new Title("Group B"));
            } else {
                lists.add(new User(image, name, age, gender, favorite, isFavorite));
            }
        }
        return lists;
    }

    public static ItemList getDataById(int position) {
        int image;
        ItemList item;
        String name = "User " + position;
        String age = "Age: " + position;
        String gender;
        int favorite;
        boolean isFavorite = false;
        if (position % 2 == 0) {
            image = R.drawable.ic_boy;
            gender = "Gender: Male " + position;
        } else {
            image = R.drawable.ic_girl;
            gender = "Gender: Female " + position;
        }
        favorite = R.drawable.ic_star_border;
        if (position % 5 == 0) {
            item = new Title("Group A");
        } else if (position % 7 == 1) {
            item = new Title("Group B");
        } else {
            item = new User(image, name, age, gender, favorite, isFavorite);
        }
        return item;
    }
}