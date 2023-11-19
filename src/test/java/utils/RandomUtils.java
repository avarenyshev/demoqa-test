package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
public class RandomUtils {
    public static void main(String[]args){
        System.out.println(getRandomGender());

    }
    public static String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }
    public static String getRandomItemFromArray(String[] array){
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }
}
