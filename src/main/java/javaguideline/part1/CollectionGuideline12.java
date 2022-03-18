package javaguideline.part1;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class CollectionGuideline12 {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Husky> huskies = Lists.newArrayList(new Husky(), new Husky());
        List<Corgi> corgis = Lists.newArrayList(new Corgi(), new Corgi());

        addAll(dogs, huskies);
        addAll(dogs, corgis);

        addAll(animals, huskies);
        addAll(animals, corgis);
    }

    public static void addAll(List<? super Dog> dest, List<? extends Dog> src) {
        dest.addAll(src);
    }

    private static class Animal {}
    private static class Dog extends Animal {}
    private static class Husky extends Dog {}
    private static class Corgi extends Dog {}

}
