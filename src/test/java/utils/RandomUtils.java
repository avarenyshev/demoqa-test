package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
public class RandomUtils {
    RandomUtils randomUtils = new RandomUtils();
    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+ 1);
    }
    public static void main(String[]args){
        System.out.println(getRandomGender());
        System.out.println(getRandomHobbie());
        System.out.println(getRandomSubject());
    }
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);

    }
    public static String getRandomSubject() {
        String[] genders = {"Math", "Economy", "History"};
        return getRandomItemFromArray(genders);

    }
    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }
    public static String getRandomHobbie() {
        String[] hobbies = {"Sports", "123", "321"};
        return getRandomItemFromArray(hobbies);
    }

//    }
//    public static String getRandomItemFromArray(String[] array){
//        int index = getRandomInt(0, array.length -1);
//    }


    }