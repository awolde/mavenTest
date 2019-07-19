import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestTest extends test{

   public String url="http://172.17.0.1:8090";

   @Test
	 public void makeSureServerIsUp() {
		 given().when().get(url).then().statusCode(200);
	 }

   @Test
	 public void checkFor40x() {
		 given().when().get(url+"/stream").then().statusCode(404);
	 }

	@Test
	public void agentTesting() {
		given().when().get(url+"/stream/1").then()
      .body("headers.User-Agent",equalTo("Apache-HttpClient/4.5.3 (Java/1.8.0_212)"))
      .statusCode(200);
	}
}
