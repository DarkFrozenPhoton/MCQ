import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class main {
	public static void main(String[] args)
											throws IOException{
		String input, create, run, creates, runs;
		create = "c";
		run = "r";
		creates = "f";
		runs = "z";
		Scanner kb = new Scanner (System.in);
		System.out.println("\t\tWelcome to the MCQ Software");
		System.out.println("What do you want to do?");
		System.out.println("[c] Create a MCQ");
		System.out.println("[r] Run a MCQ");
		System.out.println("[f] Create a MCQ");
		System.out.println("[z] Run a MCQ");
		input = kb.nextLine();
		if (input.equals(create)){
		    create_MCQ.create();
		}
		if (input.equals(run)){
			RunMCQ.run();
		}
		if (input.equals(creates)){
		    create_ScrambledMCQ.create();
		}
		if (input.equals(runs)){
			RunScrambledMCQ.run();
		}
		kb.close();
	}

}
