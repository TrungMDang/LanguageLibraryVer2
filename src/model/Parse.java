import java.io.*;
import java.util.*;


public class Parse {

	private String input_file = "./database.csv";
	private BufferedReader br = null;
	private String line = "";
	private String split = ",";

	public static void main(String[] args) {

		Parse file = new Parse();
		file.listAll();

		System.out.println("Enter search keyword: ");
		Scanner input = new Scanner(System.in);
		String keyword = input.nextLine();
		file.search(keyword);

		System.out.println("Start adding a new data.");
		System.out.println("input title:");
		String title_add = input.nextLine();
		System.out.println("input keyword:");
		String keyword_add = input.nextLine();
		System.out.println("input content:");
		String content_add = input.nextLine();
		file.add(title_add, keyword_add, content_add);
        
		System.out.println("Database updated successfully!");
	}

	public void listAll() {

		try {

			br = new BufferedReader(new FileReader(input_file));

			while ((line = br.readLine()) != null) {

				String[] cell = line.split(split);
				System.out.println(cell[0] + " " + cell[1] + " " + cell[2]);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void search(String keyword) {
		try {

			br = new BufferedReader(new FileReader(input_file));

			while ((line = br.readLine()) != null) {

				String[] cell = line.split(split);
				if (cell[1].equals(keyword)) {
					System.out.println(cell[0] + " " + cell[1] + " " + cell[2]);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void add(String title, String keyword, String content) {
		try {
			BufferedWriter bw= new BufferedWriter(new FileWriter(input_file,true));
            bw.write(title+","+keyword+","+content);
            bw.newLine();
            bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
