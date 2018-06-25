package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.then;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
//import static org.junit.Assert.assertThat;


public class GetData {
//@Test
public void testResponsecode() {
	Response response=RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
int code=response.getStatusCode();

ResponseBody<?> body = response.getBody();
String bodyAsString = body.asString();
System.out.println("Dats is @@@@@@: " +bodyAsString);
Assert.assertEquals(code, 200);
String contentType = response.getContentType();
System.out.println("Content Type is: " + contentType);

String data = response.asString();

System.out.println("LALALALALA: " + data);

JsonPath jsonPathEvaluator = response.jsonPath();
/*
String data = response.asString();

JsonPath jsonPathEvaluator = response.jsonPath();

String city = jsonPathEvaluator.get("city");
System.out.println("City received from Response " + city);
//Assert.assertEquals(city, "Hyderabad", "Correct");
*/

//System.out.println("Status Code: " +code);

}
@Test
public void gettingResponse() {
	when().
	get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
    then().
    statusCode(200);

}


}
