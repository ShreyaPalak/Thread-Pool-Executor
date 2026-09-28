# Thread-Pool-Executor

# Thread Pool Executor

A Java project demonstrating how to customize and work with `ThreadPoolExecutor` for concurrent task execution.

The project extends Java's built-in `ThreadPoolExecutor` and demonstrates how executor lifecycle hooks such as `beforeExecute()` and `afterExecute()` can be overridden to monitor task execution.

## Overview

Creating a new thread for every task can introduce unnecessary overhead when an application has many short-lived tasks.

A thread pool addresses this by maintaining a set of reusable worker threads. Tasks are submitted to the pool and executed by available workers.

This project demonstrates:

- Creating a custom `ThreadPoolExecutor`
- Configuring core and maximum pool sizes
- Using a blocking task queue
- Prestarting core worker threads
- Submitting multiple tasks
- Monitoring task execution using executor hooks
- Gracefully shutting down the executor

## Project Structure

```text
Thread-Pool-Executor/
│
├── CustomThreadPoolExecutor.java
├── DemoExecutor.java
├── DemoTask.java
├── manual/
└── README.md
