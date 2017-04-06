import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
public class create_MCQ {
	static String mcqName, answerfile, questionfile, question, answer, falseanswer1, falseanswer2;
	static int z;
	public static void create() {
		question = null;
		answer = null;
		z = 0;
		System.out.println("How would you like to name your quizz?");
		Scanner keb = new Scanner (System.in);
		mcqName = keb.nextLine();
		answerfile = mcqName +"answers";
		questionfile = mcqName +"questions";
		while (z == 0){
			System.out.println("Question : ");
			question = keb.nextLine();
			if (question.equals("quit")){
				break;
			}
			System.out.println("Answer : ");
			answer = keb.nextLine();
			if (answer.equals("quit")){
				break;
			}
			System.out.println("False answer 1: ");
			falseanswer1 = keb.nextLine();
			if (answer.equals("quit")){
				break;
			}
			System.out.println("False answer 2: ");
			falseanswer2 = keb.nextLine();
			if (answer.equals("quit")){
				break;
			}
			try(FileWriter fw = new FileWriter (questionfile, true);
				BufferedWriter bw = new BufferedWriter (fw);
				PrintWriter out = new PrintWriter(bw)){
				out.print(question +"?");
				out.print("\n");
			}catch (IOException e){
		}
			try(FileWriter fiw = new FileWriter (answerfile, true);
					BufferedWriter buw = new BufferedWriter (fiw);
					PrintWriter out = new PrintWriter(buw)){
						out.print(answer);
						out.print("\n");
			}catch (IOException e){
			}
			try(FileWriter ww = new FileWriter (mcqName + "falseanswerfile1", true);
				BufferedWriter bb = new BufferedWriter (ww);
				PrintWriter out = new PrintWriter(bb)){
				out.print(falseanswer1);
				out.print("\n");
			}catch (IOException e){
		}
		try(FileWriter nn = new FileWriter (mcqName + "falseanswerfile2", true);
			BufferedWriter mm = new BufferedWriter (nn);
			PrintWriter out = new PrintWriter(mm)){
			out.print(falseanswer2);
			out.print("\n");
		}catch (IOException e){
	}
	}

}
}
