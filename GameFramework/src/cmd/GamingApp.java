package cmd;

import java.util.Scanner;

public class GamingApp {

	public static void main(String[] args) throws Exception {
		System.out.println("Type in the game you would like to play [numberguessing, wordguessing]: ");
		Scanner scanner = new Scanner(System.in);
		String game = scanner.nextLine();
		GameFramework framework = new GameFramework();
		framework.play(game);
		scanner.close();
	}
}
