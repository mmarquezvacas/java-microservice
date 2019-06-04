package com.pichincha;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jayway.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource(value={"classpath:application.properties"})
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringRestControllerTest {

    @Value("${server.port}")
            int port;


    private JSONObject jsonPayLoad;
    private  JSONObject validJSONResponse;
    private  JSONObject errorJSONResponse;

    @Test
    public void postMessageTest()  throws JSONException {
        given()
                .header("X-Parse-REST-API-Key", DevOpsSpringRestController.STATIC_REST_API_KEY)
                .contentType(ContentType.JSON)
                .body(jsonPayLoad.toString())
                .post("/DevOps")
                 .then()
                .assertThat()
                .body("message", equalTo(validJSONResponse.get("message")));
    }

    @Test
    public void shouldReturnErrorForGetHttpMethod() throws JSONException {
        given()
                .header("X-Parse-REST-API-Key", DevOpsSpringRestController.STATIC_REST_API_KEY)
                .contentType(ContentType.JSON)
                .body(jsonPayLoad.toString())
                .get("/DevOps")
                .then()
                .assertThat()
                .body("message", equalTo(errorJSONResponse.get("message")));
    }

    @Test
    public void shouldReturnErrorForDeleteHttpMethod() throws JSONException {
        given()
                .header("X-Parse-REST-API-Key", DevOpsSpringRestController.STATIC_REST_API_KEY)
                .contentType(ContentType.JSON)
                .body(jsonPayLoad.toString())
                .delete("/DevOps")
                .then()
                .assertThat()
                .body("message", equalTo(errorJSONResponse.get("message")));
    }

    @Test
    public void shouldReturnErrorForPutHttpMethod() throws JSONException {
        given()
                .header("X-Parse-REST-API-Key", DevOpsSpringRestController.STATIC_REST_API_KEY)
                .contentType(ContentType.JSON)
                .body(jsonPayLoad.toString())
                .put("/DevOps")
                .then()
                .assertThat()
                .body("message", equalTo(errorJSONResponse.get("message")));
    }

    @Test
    public void shouldReturnErrorForInvalidRestApiKey() throws JSONException {
        given()
                .header("X-Parse-REST-API-Key", "invalidaApiKey")
                .contentType(ContentType.JSON)
                .body(jsonPayLoad.toString())
                .post("/DevOps")
                .then()
                .assertThat()
                .body("message", equalTo(errorJSONResponse.get("message")));
    }

    @Before
    public void setBaseUri () throws JSONException {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
        jsonPayLoad = new JSONObject();
        jsonPayLoad.put("message", "This is a test");
        jsonPayLoad.put("to", "Juan Perez");
        jsonPayLoad.put("from", "Rita Asturia");
        jsonPayLoad.put("timeToLifeSec", 45);

        validJSONResponse = new JSONObject();
        validJSONResponse.put("message", "Hello Juan Perez your message will be send");

        errorJSONResponse = new JSONObject();
        errorJSONResponse.put("message", "ERROR");
    }

}

