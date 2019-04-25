package by.epam.thread.main;

import by.epam.thread.threads.RepeatTask;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        int delay = 0;
        long period = 20 * 1000L;
        timer.schedule(new RepeatTask(), delay, period);
    }
}
