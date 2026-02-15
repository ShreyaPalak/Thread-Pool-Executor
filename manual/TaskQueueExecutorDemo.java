public class TaskQueueExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 5;
        int queueSize = 50;
        
        // Create custom executor with TaskQueue
        CustomExecutor executor = new CustomExecutor(numThreads, queueSize);
        
        // Submit 20 tasks
        System.out.println("Submitting 20 tasks...");
        for (int i = 1; i <= 20; i++) {
            DemoTask task = new DemoTask("Task " + i);
            boolean submitted = executor.submitTask(task);
            if (submitted) {
                System.out.println("Task " + i + " submitted successfully");
            } else {
                System.out.println("Queue is full! Task " + i + " could not be submitted");
            }
        }
        
        // Wait for all tasks to complete
        Thread.sleep(15000);
        
        // Shutdown executor
        executor.shutdown();
    }
}
