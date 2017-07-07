import http.HttpUtils;
import timer.GetSJDatasJob;
import timer.GetSJTokenJob;

public class Main {

    public static void main(String[] args) {
        try {
            HttpUtils.init();
            new GetSJTokenJob().execute(null);
            Thread.sleep(5*1000);
            new GetSJDatasJob().execute(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
