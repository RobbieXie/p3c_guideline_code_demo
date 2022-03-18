package javaguideline.part1;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class CollectionGuideline14 {

    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("xietiandi", "test", "foreach");
        for (String string : strings) {
            if ("xietiandi".equals(string)) {
                strings.remove(string);
            }
        }

        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("xietiandi".equals(next)) {
                iterator.remove();
            }
        }
    }

}
