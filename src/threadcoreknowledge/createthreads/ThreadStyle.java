package threadcoreknowledge.createthreads;

/**
 * @ClassName: ThreadStyle
 * @Description: 继承Thread类方式实现线程
 * @Author 李泽波
 * @Date 2021/6/9
 * @Version 1.0
 */
public class ThreadStyle extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread类方式实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
