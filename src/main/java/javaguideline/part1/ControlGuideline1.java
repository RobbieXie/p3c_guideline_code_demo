package javaguideline.part1;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class ControlGuideline1 {

    public static void main(String[] args) {
        String str = null;
        switch (str) {
            case "1":
                System.out.println("1");
                break;
            case "test":
                System.out.println("test");
                break;
            default:
                System.out.println("default");
        }
        System.out.println("finished");
    }

}
