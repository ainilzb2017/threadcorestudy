package threadcoreknowledge.startthread;

/**
 * @ClassName: StartAndRunMethod
 * @Description: 对比start和run两种启动线程的方式
 * @Author 李泽波
 * @Date 2021/6/9
 * @Version 1.0
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
