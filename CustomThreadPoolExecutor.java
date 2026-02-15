import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor{
    public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("Before executing: " + t.getName());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("After executing: " + Thread.currentThread().getName());
    }
}