package com.wjh.common.id;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * 测试结果：1w并发无重复
 */
public class UUIDTest {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
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
                String id = UUID.randomUUID().toString();
                if (set.contains(id))
                    System.out.println("重复=>" + id + ",threadName=>" + Thread.currentThread().getName());
                else set.add(id);
            });
        }
    }
}
