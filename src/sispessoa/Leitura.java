package sispessoa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author Edilson do Nascimento
 *
 */
public class Leitura {

	public String entDados(String dados) {
		
		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(teclado);		
		String s = "";

		System.out.println(dados);

		try {
			s = buffer.readLine();
		} catch (IOException ioe) {
			System.out.println("\n Erro no sistema ou na JVM");
		}
		return s;
	}
}
