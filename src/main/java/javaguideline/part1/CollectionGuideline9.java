package javaguideline.part1;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class CollectionGuideline9 {

    public static void main(String[] args) {
        ArrayList<String> stringList = Lists.newArrayList("xietiandi", "test", "toArray");

//        Object[] stringObjects = stringList.toArray();
//        String[] strings = (String []) stringObjects;

        String[] strings = stringList.toArray(new String[0]);
        Arrays.stream(strings).forEach(System.out::println);

        strings = stringList.toArray(new String[2]);
        Arrays.stream(strings).forEach(System.out::println);
    }

}
