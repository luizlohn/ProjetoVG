import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;




public class LuizAPITest {
	
	
	
	public LuizAPITest(){
		
		baseURI = "http://dump.getpostman.com/blog/users/"; //Site das fontes
	}


	@Test
	/*Primeiro m�todo: POST*/ //POST ENVIA AS INFORMA��ES
    public void vaiCriarUsuario() {
        String myRest = "{\"username\":\"abhinav\",\"password\": \"abc\"}";
         
         given()
           .contentType("application/json")
           .body(myRest)
         .when()
           .post("/")
         .then()
           .statusCode(200)
           .body("message", containsString("User created successfully"));    
    }
	

	@Test
	/*Segundo m�todo: GET*/ //GET PEGA AS INFORMA��ES
	    public void validarDadosUsuario() {	         
	         given()
	         .when()
	            .get("/1")
	         .then()
	         	//Come�a a validar bom base no /1 usu�rio
	            .statusCode(200)
	            .body("created_at", is(1396006450))
	            .body("id", is(1))
	            .body("token", equalTo("JbaGIjDQMyvbTyRNsAqmOMijTnpUez"))
	            .body("username", equalTo("prakhar1989"))
	            .assertThat()
	               .body(matchesJsonSchemaInClasspath("schema_exemplo.json"));
	    }
}
