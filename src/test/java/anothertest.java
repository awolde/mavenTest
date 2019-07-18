import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class anothertest {
  public static void main (String[] args) {
		 given().when().get("http://www.google.com").then().statusCode(200);
  }
}
