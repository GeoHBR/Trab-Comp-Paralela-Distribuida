package pacote;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class ManipuladorArquivo {
	
	public static void leitor(String dirPath) throws IOException {
		boolean encontrado = false;
		try (Stream<Path> paths = Files.walk(Paths.get(dirPath))) {
			Iterator<Path> iterator = paths.iterator();
			String nome = JOptionPane.showInputDialog("Digite um nome");
			while (iterator.hasNext() && !encontrado) {
				Path path = iterator.next();
				if (Files.isRegularFile(path)) {
					try {
						BufferedReader buffRead = Files.newBufferedReader(path);
						String linha;
						int count =0;
						
						while ((linha = buffRead.readLine()) != null && !encontrado) {
							System.out.println(linha);
							count++;
							if(linha.equalsIgnoreCase(nome)) {
								JOptionPane.showMessageDialog(null, "Nome encontrado: " +nome +"\nNa Linha: "+count+"\nDo Arquivo: "+path);
								System.out.println("Nome encontrado: " +nome +"\nNa Linha:"+count+"\nNo Arquivo: "+path);
								encontrado = true;
							}
						}
					} catch (IOException e) {
						  System.out.println("Não foi Encontrado");
					}
				}
			}
			
			if (!encontrado) {
				int resposta = JOptionPane.showConfirmDialog(null, "Nome não encontrado. Tentar novamente?", "Nome não encontrado", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					leitor(dirPath);
				}
			}
		}
	}
}
