import http.HttpUtils;
import timer.GetSJDatasJob;
import timer.GetSJTokenJob;
import utils.MathUtils;

public class Main {

    public static void main(String[] args) {
//        try {
//            HttpUtils.init();
//            new GetSJTokenJob().execute(null);
//            Thread.sleep(5*1000);
//            new GetSJDatasJob().execute(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        double a = 0.032;
        double b = 3.12;
        System.out.println(0.02+0.12);
        System.out.println(MathUtils.add(0.02,0.12));
        System.out.println(MathUtils.sub(0.02,0.12));
        System.out.println(MathUtils.multiply(0.02,0.12));
        System.out.println(MathUtils.div(0.02,0.12));
    }
}
