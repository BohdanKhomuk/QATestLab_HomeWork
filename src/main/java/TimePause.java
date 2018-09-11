public class TimePause {

    public void userDelay(int time) {
        try {Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace(); }
    }

}
