import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;




public class LuizAPITest {
	
	
	
	public LuizAPITest(){
		
		baseURI = "http://dump.getpostman.com/blog/users/"; //Site das fontes
	}


	@Test
	/*Primeiro método: POST*/ //POST ENVIA AS INFORMAÇÕES
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
	/*Segundo método: GET*/ //GET PEGA AS INFORMAÇÕES
	    public void validarDadosUsuario() {	         
	         given()
	         .when()
	            .get("/1")
	         .then()
	         	//Começa a validar bom base no /1 usuário
	            .statusCode(200)
	            .body("created_at", is(1396006450))
	            .body("id", is(1))
	            .body("token", equalTo("JbaGIjDQMyvbTyRNsAqmOMijTnpUez"))
	            .body("username", equalTo("prakhar1989"))
	            .assertThat()
	               .body(matchesJsonSchemaInClasspath("schema_exemplo.json"));
	    }
}
