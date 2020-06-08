package core.thread_LFY;

import java.util.concurrent.*;

public class ThreadTest {
    /**
     * 1）、继承 Thread
     * 2）、实现 Runnable 接口
     * 3）、实现 Callable 接口 + FutureTask (可以拿到返回结果，可以处理异常)
     * 4）、线程池
     *
     * 区别
     * 1，2不能得到返回值
     * 1，2，3都不能控制资源
     * 4 可以控制资源 性能稳定。稳定第一
     */

    public static  ExecutorService executorService = Executors.newFixedThreadPool(10);

        public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("main...start...");
//        Thread01 thread01 = new Thread01();
//        thread01.start();
//
//        System.out.println("main...end...");


//        System.out.println("main...start...");
//        Runable01 runable01 = new Runable01();
//        new Thread(runable01).start();
//        System.out.println("main...end...");

//        System.out.println("main...start...");
//        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable01());
//        new Thread(integerFutureTask).start();
//        //阻塞等待整个线程执行完成，获取返回结果
//        Integer integer = integerFutureTask.get();
//        System.out.println("main...end..." + integer);

            //以后的业务代码，以上三种启动线程的方式都不能用，无法控制资源，会耗尽系统资源
            //应该将所有的多线程异步任务都交个线程池执行

            //当前系统中池只有一两个，每个异步任务，提交给线程池即可
            System.out.println("main...start...");
            executorService.execute(new Runable01());
            System.out.println("main...end...");

        }

    //1）、继承 Thread
    public static class Thread01 extends Thread {
        public void run() {
            System.out.println("当前线程： "+ Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果： " + i);
        }
    }

    //2）、实现 Runnable 接口
    public static class Runable01 implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程： "+ Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果： " + i);
        }
    }

    //3）、实现 Callable 接口 + FutureTask (可以拿到返回结果，可以处理异常)
    public static class Callable01 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程： "+ Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果： " + i);
            return i;
        }
    }

    //4）、线程池  给线程池提交任务
}
