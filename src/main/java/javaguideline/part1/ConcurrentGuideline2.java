package javaguideline.part1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class ConcurrentGuideline2 {

    public static void main(String[] args) {
        System.out.println("main-thread...");

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " start");
            LockSupport.park();
        };

        AtomicInteger atomicInteger = new AtomicInteger(0);
        new Thread(runnable).start();
        new Thread(null,  runnable, "test-thread" + atomicInteger.incrementAndGet()).start();
    }
}
