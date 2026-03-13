package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class RaceConditionNew {
    static class Counter {
        private final LongAdder count = new LongAdder();

        public void increment() {
            count.increment();
        }

        public long getCount() {
            return count.sum();
        }
    }

    public static void main(String[] args) throws Exception {
        Counter counter =new Counter();
        int workers = Runtime.getRuntime().availableProcessors(); //scalable
        int iterations = 1000;
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int w = 0; w < workers; w++) {
                executorService.submit(() -> {
                   for (int i=0; i < iterations; i++) {
                       counter.increment();
                   }
                });
            }
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        }
        System.out.println("Final count: " + counter.getCount());
    }
}