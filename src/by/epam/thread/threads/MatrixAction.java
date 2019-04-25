package by.epam.thread.threads;

import by.epam.thread.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static by.epam.thread.storage.ValueBasket.getValueBasketInstance;

public class MatrixAction extends Thread {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void run() {
        Matrix matrix = Matrix.getMatrixInstance();
        int i = 0; //diagonal number
        int sum = 0; //sought value
        try {
            TimeUnit.MICROSECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            logger.error("Interrupted Exception", e);
        }
        boolean signal = true;
        while (signal) {
            int nameOfThread = Integer.parseInt(this.getName().substring(7));
            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            if (matrix.getElement(i, i) == 0) {
                try {
                    //[i][i] - position in Matrix, value -  name of Thread
                    matrix.changeElement(i, nameOfThread);
                    signal = false; //out of cycle if successful replace
                } finally {
                    lock.unlock();
                }
                int [][] squareMatrix = matrix.getSquareMatrix();
                for (int k: squareMatrix[i]) {
                    sum += k;
                }
                lock.lock();
                try {
                    //put sum of elements in ValueBasket, key is name of Thread
                    getValueBasketInstance().putElement(nameOfThread, sum);
                } finally {
                    lock.unlock();
                }
                logger.info("Put in Value Basket: key = " + nameOfThread + " , value = " + sum);
            } else {
                i++; //if replacement did not occur, try with the next line
            }
        }
    }
}
