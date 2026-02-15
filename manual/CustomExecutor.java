public class CustomExecutor {
    private TaskQueue taskQueue;
    private Thread[] threads;
    private volatile boolean running = true;
    
    public CustomExecutor(int numThreads, int queueSize) {
        this.taskQueue = new TaskQueue(queueSize);
        this.threads = new Thread[numThreads];
        
        // Start worker threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                while (running) {
                    Runnable task = taskQueue.get();
                    if (task != null) {
                        try {
                            System.out.println("Worker " + Thread.currentThread().getName() + " executing task");
                            task.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            threads[i].setName("Worker-" + (i + 1));
            threads[i].start();
        }
    }
    
    public boolean submitTask(Runnable task) {
        return taskQueue.put(task);
    }
    
    public void shutdown() {
        running = false;
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Executor shutdown complete");
    }
}
