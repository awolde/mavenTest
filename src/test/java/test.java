//import static com.jayway.restassured.RestAssured.given;
import io.restassured.RestAssured;
//import static io.restassured.RestAssured.given;
//import static io.restassured.config.JsonConfig.jsonConfig;
//import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.DOUBLE;
import org.junit.Test;
//import static org.hamcrest.Matchers.*;

public class test {
//  @Test
//  @BeforeClass
  public void setup() {
    String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8090);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/stream";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://172.18.0.1";
        }
        RestAssured.baseURI = baseHost;
  }
}
