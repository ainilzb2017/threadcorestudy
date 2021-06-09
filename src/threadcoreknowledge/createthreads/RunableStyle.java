package threadcoreknowledge.createthreads;

/**
 * @ClassName: RunableStyle
 * @Description: 实现Runable接口实现线程
 * @Author 李泽波
 * @Date 2021/6/9
 * @Version 1.0
 */
public class RunableStyle implements Runnable{

    @Override
    public void run() {
        System.out.println("实现Runable接口实现线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunableStyle());
        thread.start();
    }
}
