package io.apicurio.codegen.tests.basic.api;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.type.TypeFactory;

import io.apicurio.codegen.tests.basic.api.beans.Widget;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class WidgetsResourceTest {

    @Test
    public void testNoWidgets() {
        @SuppressWarnings("unchecked")
        List<Widget> widgets = given()
            .when().get("/widgets")
            .then()
                .statusCode(200)
                .extract().as(List.class);
        assertEquals(0, widgets.size());
    }

    @Test
    public void testCreateWidget() {
        Widget widget = new Widget();
        widget.setName("Test");
        widget.setDescription("A test widget.");

        given()
            .when().body(widget).contentType(ContentType.JSON).post("/widgets")
            .then()
                .statusCode(204);

        List<Widget> widgets = given()
            .when().get("/widgets")
            .then()
                .statusCode(200)
                .extract().as(
                    TypeFactory.defaultInstance().constructCollectionLikeType(List.class, Widget.class)
                );
        assertEquals(1, widgets.size());
        assertEquals("Test", widgets.get(0).getName());
        assertEquals("A test widget.", widgets.get(0).getDescription());
    }

}