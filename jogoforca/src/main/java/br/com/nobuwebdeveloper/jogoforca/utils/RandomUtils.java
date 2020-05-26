package br.com.nobuwebdeveloper.jogoforca.utils;

import java.util.Random;

public class RandomUtils {

	private static Random random = new Random();
	
	public static int newRandomNumber(int min, int max) {
		 return random.nextInt(max - min + 1) + min;
	}
}

