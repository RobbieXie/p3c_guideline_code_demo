package javaguideline.part1;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class CollectionGuideline4 {

    public static void main(String[] args) {
        ArrayList<User> users = Lists.newArrayList(
                new User("xietiandi", "male"),
                new User("xietiandi", "male"),
                new User("xtd", null)
        );

//        users.stream().collect(Collectors.toMap(User::getName, User::getSex));

//        users.stream().collect(Collectors.toMap(User::getName, User::getSex, (v1, v2) -> v2));

        users.stream().collect(HashMap::new,
                (hashMap, user) -> hashMap.put(user.getName(), user.getSex()),
                HashMap::putAll).forEach((key, value) -> System.out.println(key + ":" + value));
    }

    @AllArgsConstructor
    @Getter
    public static class User {
        private String name;
        private String sex;
    }
}
