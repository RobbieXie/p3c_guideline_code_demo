package javaguideline.part1;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class ControlGuideline4 {

    public static void main(String[] args) {

        Boolean flag = false;

        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Integer result = (flag ? Integer.valueOf(a * b) : c);

        System.out.println(result);
    }

}
