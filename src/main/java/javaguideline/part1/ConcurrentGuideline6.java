package javaguideline.part1;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Robbie Xie
 * since 2022-03-16.
 */
public class ConcurrentGuideline6 {

    /**
     * 5MB buffer
     */
    private static final ThreadLocal<ByteBuffer> BYTE_BUFFER_THREAD_LOCAL =
            ThreadLocal.withInitial(() -> ByteBuffer.allocate(5 * 1024 * 1024));

    private static final ThreadLocal<ByteBuffer> BYTE_BUFFER_THREAD_LOCAL_2 =
            ThreadLocal.withInitial(() -> ByteBuffer.allocate(5 * 1024 * 1024));

    private static final ThreadLocal<ByteBuffer> BYTE_BUFFER_THREAD_LOCAL_3 =
            ThreadLocal.withInitial(() -> ByteBuffer.allocate(5 * 1024 * 1024));

    public static void main(String[] args) {
        System.out.println("main-thread...");

        Runnable runnable = () -> {
            BYTE_BUFFER_THREAD_LOCAL.get();
            System.out.println(Thread.currentThread().getName() + "get ByteBuffer 1");
            LockSupport.parkNanos(Duration.ofSeconds(2).toNanos());
            BYTE_BUFFER_THREAD_LOCAL.remove();
        };

        Runnable runnable2 = () -> {
            BYTE_BUFFER_THREAD_LOCAL_2.get();
            System.out.println(Thread.currentThread().getName() + "get ByteBuffer 2");
            LockSupport.parkNanos(Duration.ofSeconds(2).toNanos());
            BYTE_BUFFER_THREAD_LOCAL_2.remove();
        };

        Runnable runnable3 = () -> {
            BYTE_BUFFER_THREAD_LOCAL_3.get();
            System.out.println(Thread.currentThread().getName() + "get ByteBuffer 3");
            LockSupport.parkNanos(Duration.ofSeconds(2).toNanos());
            BYTE_BUFFER_THREAD_LOCAL_3.remove();
        };

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(5), Executors.defaultThreadFactory());

        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable2);
        threadPoolExecutor.execute(runnable3);

        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable2);
        threadPoolExecutor.execute(runnable3);

    }
}
