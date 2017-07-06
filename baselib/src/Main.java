import http.HttpUtils;
import timer.GetSJDatasJob;
import timer.GetSJTokenJob;

public class Main {

    public static void main(String[] args) {
        try {
            new GetSJTokenJob().execute(null);
            Thread.sleep(5);
            new GetSJDatasJob().execute(null);
//            new HttpUtils().getSjToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
