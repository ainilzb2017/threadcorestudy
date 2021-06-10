package threadcoreknowledge.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName: WrongWayVolatileCantStop
 * @Description: 演示volatile的局限part2
 * 陷入阻塞时，volatile是无法停止线程的
 * 此例中，生产者的生产速度很快，而消费者的消费速度很慢，所以会造成阻塞队列满了之后，生产者会阻塞，生产者会等待消费者进一步消费
 * @Author 李泽波
 * @Date 2021/6/10
 * @Version 1.0
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);
        Consumer consumer = new Consumer(storage);
        while(consumer.needMoreNums()){
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        //一旦消费者不需要更多数据了，我们应该让生产者也停下来，但是实际情况
        producer.canceled = true;
    }
}

class Producer implements Runnable{
    public volatile boolean canceled =false;
    BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while(num <= 10000 && !canceled){
                if(num % 100 == 0){
                    storage.put(num);
                    System.out.println(num + "是100的倍数,被放到仓库中了");
                }
                num++;
                Thread.sleep(1);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者结束运行");
        }
        int j = 0;
        while(j < 10){
            System.out.println("我还在运行ing");
            j++;
        }
    }
}

class Consumer{
    BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }
    public boolean needMoreNums(){
        if(Math.random() > 0.95){
            return false;
        }
        return true;
    }

}
