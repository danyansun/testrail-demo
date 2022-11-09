package testrail;

/**
 * @author niki
 */
public final class CreateClient {
    public testrail.APIClient apiClient;

    private CreateClient() {
        apiClient = new testrail.APIClient("https://nikitest0222.testrail.io/");
        apiClient.setUser("nikisun@xm.wonder.com");
//        apiClient.setPassword("vr2OPRSU4X6K3.ErUqCE-fv5qP4hCO6hCRGGjk53J");
        apiClient.setPassword("Chance0830");
        System.out.println("apiClient = " + apiClient);
    }

    private static class ClassHolder{
        private static final CreateClient INSTANCE = new CreateClient();
    }

    public static CreateClient of() {
        return ClassHolder.INSTANCE;
    }
}
