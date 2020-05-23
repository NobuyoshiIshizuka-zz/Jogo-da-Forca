package br.com.nobuwebdeveloper.jogoforca.game;

import br.com.nobuwebdeveloper.jogoforca.core.Dictionary;
import br.com.nobuwebdeveloper.jogoforca.core.Word;

public class Game {

	public void start() {
		
        Dictionary d1 = Dictionary.getInstance();
        Dictionary d2 = Dictionary.getInstance();
        
        System.out.println(d1);
        System.out.println(d2);
        
		Word w1 = d1.nextWord();
		System.out.println(w1.getOriginalWord());
	}
}
