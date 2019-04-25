package by.epam.thread.threads;

import by.epam.thread.creator.MatrixCreator;
import by.epam.thread.storage.ValueBasket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import static by.epam.thread.entity.Matrix.getMatrixInstance;

public class RepeatTask extends TimerTask {
    private static final Logger logger = LogManager.getLogger();
    private MatrixCreator creator = new MatrixCreator();
    @Override
    public void run() {
        //Re-initialization of the Matrix each time the thread pool starts
        getMatrixInstance().setSquareMatrix(creator.createMatrix());
        logger.info(getMatrixInstance().toString());
        //Running a thread pool equal to the matrix length
        int length = getMatrixInstance().getSquareMatrix().length;
        for (int i = 0; i < length; i++) {
            new MatrixAction().start();
        }
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            logger.error("Interrupted Exception", e);
        }
        logger.info(getMatrixInstance().toString());
        logger.info(ValueBasket.getValueBasketInstance().toString());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            logger.error("Interrupted Exception", e);
        }
    }
}