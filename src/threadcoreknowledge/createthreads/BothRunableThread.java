package threadcoreknowledge.createthreads;

/**
 * @ClassName: BothRunableThread
 * @Description: 同时使用实现线程的两种方式会发生什么
 * @Author 李泽波
 * @Date 2021/6/9
 * @Version 1.0
 */
public class BothRunableThread {
    public static void main(String[] args) {
        new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
