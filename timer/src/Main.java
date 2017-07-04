public class Main {

    public static void main(String[] args) {
        System.out.println("thread name:"+Thread.currentThread().getName()+" Start Timer Task: ");
        new TimerFactory().runTimerTask();
        new TimerFactory().runQuartzTask();
    }


}

