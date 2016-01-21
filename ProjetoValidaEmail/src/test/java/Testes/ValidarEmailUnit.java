package Testes;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;

public class ValidarEmailUnit {

	@BeforeClass
	public static void InicioTeste(){
		System.out.println("INICIANDO OS TESTES DO VALIDADOR DE E-MAIL");
		System.out.println("IRÁ VALIDAR A SEGUINTE ESTRUTURA XXX@XXX.XXX");


		
		
	}


	public static  boolean ValidarEmail(String email) {
		System.out.println("Iniciando Testes Unitários de E-mail NW");
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
		Matcher m = p.matcher(email); 
		if (m.find()){
			System.out.println("Validador: Válido");
			return true;
		}
		else{
			System.out.println("Validador: Inválido");
			return false;
		}
	}


	@Test
	public void EmailSemArroba() {
		String email = "testeteste.com.br";
		System.out.println("---------------------------------------------------------------");
		System.out.println(email);

		assertEquals(false, ValidarEmail(email));
		System.out.println("Este e-mail é inválido: "+email);
		System.out.println("---------------------------------------------------------------");


	}
	@Test
	public void EmailValido() {
		String email = "testet@este.com.br";
		System.out.println("---------------------------------------------------------------");
		System.out.println(email);

		assertEquals(true, ValidarEmail(email));
		System.out.println("Este e-mail é válido: "+email);
		System.out.println("---------------------------------------------------------------");

	}
	@Test
	public void EmailSemponto() {
		String email = "teste@testecombr";
		System.out.println("---------------------------------------------------------------");
		System.out.println(email);

		assertEquals(false, ValidarEmail(email));
		System.out.println("Este e-mail é inválido: "+email);

		System.out.println("---------------------------------------------------------------");

	}
	@Test
	public void EmailSemTextoAntesArroba() {
		String email = "@testecombr";
		System.out.println("---------------------------------------------------------------");
		System.out.println(email);

		assertEquals(false, ValidarEmail(email));
		System.out.println("Este e-mail é inválido: "+email);

		System.out.println("---------------------------------------------------------------");

	}
	@Test
	public void EmailSemTextoAposArroba() {
		String email = "dasdas@";
		System.out.println("---------------------------------------------------------------");
		System.out.println(email);

		assertEquals(false, ValidarEmail(email));
		System.out.println("Este e-mail é inválido: "+email);

		System.out.println("---------------------------------------------------------------");

	}
	
	@Test
	public void MassadeEmail() {
		try{
			
	         BufferedReader br = new BufferedReader(new FileReader("C:/QuaTest/ProjetoNW/relatorio.txt"));
				System.out.println("-----------------------Teste de Massa----------------------------------------");

			while(br.ready()){
				String linha = br.readLine();
				System.out.println(linha);

				assertEquals(true, ValidarEmail(linha));
				System.out.println("Este e-mail é válido: "+linha);

				System.out.println("---------------------------------------------------------------");
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		
		System.out.println("--------------------Fim testes Massa-------------------------------------------");

		}
	


}
	

	
