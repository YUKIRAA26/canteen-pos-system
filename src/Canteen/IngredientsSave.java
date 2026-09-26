package Canteen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IngredientsSave {

		public static void ingSave() {
			try(BufferedWriter writer = new BufferedWriter(new FileWriter("Ingredients.txt", true))) {
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
}
