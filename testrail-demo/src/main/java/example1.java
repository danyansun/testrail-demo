import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author niki
 */
public class example1 {

    public static void main(String[] args) throws APIException, IOException {
//        addProject();
//        getProjects();
//        addTestSuite();
//        getTestSuites();
//        addSection();
//        getSections();
//        addTestCase();
        getTestCases();
//        addTestRun();
//        getTestRuns();
//        addTestResultsForCase();
    }

    public static void addProject() throws APIException, IOException {
        Map data = new HashMap();
        data.put("name", "TestRail Demo Project");
        data.put("announcement", "This is a demo for TestRail");
        data.put("show_announcement", true);
        CreateClient.of().apiClient.sendPost("/add_project", data);
    }

    public static void getProjects() throws APIException, IOException {
        JSONObject result = (JSONObject) CreateClient.of().apiClient.sendGet("/get_projects");
        System.out.println(result);
    }

    public static void addTestSuite() throws APIException, IOException {
        Map data = new HashMap();
        data.put("name", "Test Suite 1");
        data.put("description", "This is a test suite under TestRail Demo Project");
        CreateClient.of().apiClient.sendPost("/add_suite/2", data);
    }

    public static void getTestSuites() throws APIException, IOException {
        JSONArray result = (JSONArray) CreateClient.of().apiClient.sendGet("/get_suites/2");
        System.out.println(result);
    }

    public static void addSection() throws APIException, IOException {
        Map data = new HashMap();
        data.put("name", "Test Section 2");
        data.put("description", "This is a test section under Test Section 1");
        data.put("suite_id", 3);
        CreateClient.of().apiClient.sendPost("/add_section/2", data);
    }

    public static void getSections() throws APIException, IOException {
        JSONObject result = (JSONObject) CreateClient.of().apiClient.sendGet("/get_sections/2&suite_id=3");
        System.out.println(result);
    }

    public static void addTestCase() throws APIException, IOException {
        Map data = new HashMap();
        data.put("title", "Test Case 3");
        data.put("section_id", 2);
        CreateClient.of().apiClient.sendPost("/add_case/2", data);
    }

    public static void getTestCases() throws APIException, IOException {
        JSONObject result = (JSONObject) CreateClient.of().apiClient.sendGet("/get_cases/2&suite_id=3&offset=2");
        System.out.println(result);
    }

    public static void addTestRun() throws APIException, IOException {
        Map data = new HashMap();
        data.put("name", "Test Run 2");
        data.put("suite_id", 3);
        data.put("description", "This is a test run for Test Suite 1");
        CreateClient.of().apiClient.sendPost("/add_run/2", data);
    }

    public static void getTestRuns() throws APIException, IOException {
        JSONObject result = (JSONObject) CreateClient.of().apiClient.sendGet("/get_runs/2");
        System.out.println(result);
    }

    public static void addTestResultsForCase() throws APIException, IOException {
        Map data = new HashMap();
        data.put("status_id", 1);
        data.put("comment", "success!!!");
        data.put("version", "1.0.0");
        CreateClient.of().apiClient.sendPost("/add_result_for_case/17/14", data);
    }



}
