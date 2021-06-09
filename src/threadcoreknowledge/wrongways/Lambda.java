package threadcoreknowledge.wrongways;

/**
 * @ClassName: Lambda
 * @Description: lambda表达式创建线程
 * @Author 李泽波
 * @Date 2021/6/9
 * @Version 1.0
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName())){
        }.start();
    }
}
