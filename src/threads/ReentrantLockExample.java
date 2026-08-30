package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    ReentrantLock lock = new ReentrantLock();

    static void main() {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.methodA();
    }

    public void methodA(){
        lock.lock();
        try {
            System.out.println("Inside Method A");
            methodB();
        }finally {
            lock.unlock();
            System.out.println("unlocked A");

        }

    }

    public void methodB(){
        lock.lock();

        try{
            System.out.println("method B");
        }
        finally{
            lock.unlock();
            System.out.println("unlocked B");

        }

    }
}
