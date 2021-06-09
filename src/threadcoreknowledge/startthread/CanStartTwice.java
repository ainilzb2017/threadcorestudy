package threadcoreknowledge.startthread;

/**
 * @ClassName: CanStartTwice
 * @Description: 演示不能两次调用start方法，否则会报错
 * @Author 李泽波
 * @Date 2021/6/9
 * @Version 1.0
 */
public class CanStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
