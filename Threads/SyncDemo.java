/*
 * Simple thread synchronization example
 * Done using function interface of Runnable
 */
class Counter{
    int counter;
    public synchronized void increament(){
        counter++;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws Exception {
        
        Counter c = new Counter();

        Thread t1 = new Thread( ()->{
                for(short i=0 ; i<1000; i++){
                    c.increament();
                }
            }
        );

        Thread t2 = new Thread( ()->{
                for(short i=0 ; i<1000; i++){
                    c.increament();
                }
            }
        );
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Counter: "+c.counter);
    }
}