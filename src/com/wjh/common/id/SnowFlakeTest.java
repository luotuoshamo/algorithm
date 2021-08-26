package com.wjh.common.id;

import java.util.Set;
import java.util.concurrent.*;

/**
 * 测试结果：1w并发时，有1~2个重复
 */
public class SnowFlakeTest {
    public static void main(String[] args) {
        Set<Long> set = new CopyOnWriteArraySet<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(20,
                100,
                10,
                TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        for (int i = 0; i < 10000; i++) {
            pool.execute(() -> {
                long id = SnowFlake.getId();
                if (set.contains(id))
                    System.out.println("重复=>" + id + ",threadName=>" + Thread.currentThread().getName());
                else set.add(id);
            });
        }
    }
}
