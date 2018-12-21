package com.rest.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import com.rest.api.RestApiApplicationTests;
import com.rest.api.exceptions.ExceptionResponse;
import com.rest.api.exceptions.RestApiException;
import com.rest.api.models.Fruit;
import com.rest.api.services.FruitService;
import org.json.JSONException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplicationTests.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FruitControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private FruitService fruitService;

    ObjectMapper mapper = new ObjectMapper();

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    Fruit apple;
    Fruit orrange;
    Fruit banana;

    @Before
    public void before() throws RestApiException {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        apple = fruitService.create(new Fruit(1, "apple"));
        orrange = fruitService.create(new Fruit(2, "orrange"));
        banana = fruitService.create(new Fruit(3, "banana"));
    }

    @After
    public void after() {
        fruitService.removeAll();
    }

    @Test
    public void deleteRestTest() throws IOException, JSONException {

        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("3"),
                HttpMethod.DELETE, entity, String.class);


        String expected = "{\"id\":3,\"name\":\"banana\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void getRestTest() throws JSONException {

        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort(apple.getId() + ""),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":1,\"name\":\"apple\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void listRestTest() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort(""),
                HttpMethod.GET, entity, String.class);
        String expected = "[{\"id\":1,\"name\":\"apple\"},{\"id\":2,\"name\":\"orrange\"},{\"id\":3,\"name\":\"banana\"}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/api/v1/fruit/" + uri;
    }

}
