import org.json.simple.JSONObject;

/**
 * @author niki
 */
public class example {

    public static void main(String[] args) throws Exception {
        testrail.APIClient apiClient = new testrail.APIClient("https://nikitest0222.testrail.io/");
        apiClient.setUser("nikisun@xm.wonder.com");
//        apiClient.setPassword("vr2OPRSU4X6K3.ErUqCE-fv5qP4hCO6hCRGGjk53J");
        apiClient.setPassword("Chance0830");

        JSONObject result = (JSONObject) apiClient.sendGet("get_case/1");
        System.out.println(result.get("title"));

    }
}
