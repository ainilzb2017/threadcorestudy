package threadcoreknowledge.sixstates;

/**
 * @ClassName: BlockedWaitingTimeWaiting
 * @Description: 展示Blocked、Waiting、TimeWaiting状态
 * @Author 李泽波
 * @Date 2021/6/10
 * @Version 1.0
 */
public class BlockedWaitingTimeWaiting implements Runnable{

    public static void main(String[] args) {
        BlockedWaitingTimeWaiting runnable = new BlockedWaitingTimeWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        //第一种：打印出Timed_Waiting状态，因为正在执行Thread.sleep(1000);
        System.out.println(thread1.getState());
        //第二种：打印出Blocked状态，因为thread2想拿到syn()的锁却拿不到。
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());

    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
