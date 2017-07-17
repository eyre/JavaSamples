import http.HttpUtils;
import timer.GetSJDatasJob;
import timer.GetSJTokenJob;
import utils.CRC;

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

        byte[] queryId = {0x02, 0x01};
        Character crc = CRC.crcVal(queryId);
        Character crc1 = CRC.crcVal1(queryId);
        System.out.println(crc);
    }
}
