package br.com.nobuwebdeveloper.jogoforca.game;

import java.util.HashSet;
import java.util.Set;

import br.com.nobuwebdeveloper.jogoforca.core.Config;
import br.com.nobuwebdeveloper.jogoforca.core.Dictionary;
import br.com.nobuwebdeveloper.jogoforca.core.InvalidCharacterException;
import br.com.nobuwebdeveloper.jogoforca.core.Word;
import br.com.nobuwebdeveloper.jogoforca.ui.UI;

public class Game {
	
	public void start(String[] args) {

		UI.print("Bem Vindo ao Jogo da Forca!");

		Dictionary dictonary = Dictionary.getInstance();
		Word word = dictonary.nextWord();

		UI.print("A palavra tem " + word.size() + " letras");

		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		if (args.length > 0) {
			Config.setMaxErrors(args[0]);
		}
		
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		UI.print("Você pode errar no máximo " + maxErrors + " vez(es)");
		
		while (true)  {
			UI.print(word);
			UI.printNewline();

			char c;
			try {
				c = UI.readChar("Digite uma letra: ");
				
				 if (usedChars.contains(c)) {
					throw new InvalidCharacterException("Esta letra já foi utilizada");
				}
				 usedChars.add(c);
				 
				 if (word.hasChar(c)) {
					UI.print("Você acetou essa letra!");
				} else {
					errorCount++;
					
					if (errorCount < maxErrors) {
						UI.print("Você errou! Você ainda pode errar: " +(maxErrors - errorCount) + "Vez(es)");
					}
				}
				 
				 UI.printNewline();
				 
				 if (word.discovered()) {
					UI.print("Parabéns você acertou a palavra completa: " + word.getOriginalWord());
					UI.print("Fim de Jogo!");
					break;
				}
				 
				 if (errorCount == maxErrors) {
					 UI.print("Você perdeu o jogo! A palavra correta era: " + word.getOriginalWord());
						UI.print("Fim de Jogo!");
						break;
				}
				 
			} catch (InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printNewline();
			}
		}

	}
}
