package pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPools {

    public static void main(String[] args) {
        ThreadFactory factory = new ThreadFactory() {
            int num = 0;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("thread-pool-thread" + num+"");
                num++;
                return thread;
            }
        };

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 3000,
            TimeUnit.SECONDS, new LinkedBlockingDeque<>(1024), factory);



        for (int i = 0; i < 50; i++) {
            MyTask task = new MyTask(i);
            pool.execute(task);
        }
        pool.shutdown();

        for (;;){
            System.out.println(pool.getQueue().size());
        }
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( Thread.currentThread().getName()+" end");
    }
}
