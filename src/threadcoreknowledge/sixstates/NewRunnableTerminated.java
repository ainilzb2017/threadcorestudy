package threadcoreknowledge.sixstates;

/**
 * @ClassName: NewRunnableTerminated
 * @Description: 展示线程的NEW、RUNNABLE、TERMINATED状态。
 * 即使是正在运行，也是Runnable状态，而不是Running状态。
 * @Author 李泽波
 * @Date 2021/6/10
 * @Version 1.0
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        //打印出RUNNABLE的状态
        System.out.println(thread.getState());
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出RUNNABLE的状态
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TERMINATED的状态
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.println(i);
        }
    }
}
