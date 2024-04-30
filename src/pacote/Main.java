package pacote;

import java.io.IOException;

public class Main {

	public static void main(String args[]) throws IOException {
		//Arquivos de Teste
		String path = "C:\\Users\\bib\\eclipse-workspace\\Trabalho\\Arquivos";

        //Arquivos do professor
//		String path = "C:\\Users\\bib\\eclipse-workspace\\Trabalho\\Arquivos";

		ManipuladorArquivo.leitor(path);
	}
}
