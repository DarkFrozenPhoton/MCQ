import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class RunMCQ {
	public static void run()
					throws IOException{
		String mcqName, answerfile, questionfile, qu, answer, oanswer1, oanswer2, oanswer3, S, Score, falseanswerfile1, falseanswerfile2;
		qu = null;
		answer = null;
		oanswer1 = null;
		oanswer2 = null;
		Score = "Score log";
		int s, g;
		int totallines = 0;
		Integer rounds, won, lost;
		int falseanswer3, falseanswer2, falseanswer1, questionline, o;
		questionline = 0;
		falseanswer1 = 0;
		falseanswer2 = 0;
		rounds = 0;
		won = 0;
		lost = 0;
		BufferedReader B;
		FileReader fr;
		System.out.println("Which Quizz do you want to do?");
		Scanner key = new Scanner (System.in);
		mcqName = key.nextLine();
		if (mcqName.equals("ls")){
			 // todo : DISLAY AVAILABLE QUIZZES
		 }
		 questionfile = mcqName +"questions";
		 answerfile = mcqName +"answers";
		 Scanner ds = new Scanner (new File(questionfile));
		 Scanner df = new Scanner (new File(answerfile));
		 while (ds.hasNextLine()){
			 totallines++;
			 String data = ds.nextLine();
		 }
		 if (totallines <= 3){
			 System.out.println("ERROR : THERE MUST BE AT LEAST 3 QUESTIONS");
			 System.exit(0);
		 }
		 Random a = new Random();
		 questionline = 1;
		 while (rounds != totallines){

		 //GET THE STRING OF THE QUESTION,THE ANSWER AND THE OTHER FALSE ANSWERS
		 qu = Files.readAllLines(Paths.get(mcqName+"questions")).get(questionline);
		 answer = Files.readAllLines(Paths.get(mcqName+"answers")).get(questionline);
		 oanswer1 = Files.readAllLines(Paths.get(mcqName+"falseanswerfile1")).get(questionline);
		 oanswer2 = Files.readAllLines(Paths.get(mcqName+"falseanswerfile2")).get(questionline);
		 questionline ++;
		 //CREATE RANDOM ORDOR OF ANSWERS
		 g = a.nextInt(3)+1;
		 System.out.println((char)27 +"[4m" + "Question :" + (char)27+"[0m" +" "+(char)27+"[1m"+(char)27+"[34m" + qu +(char)27+"[0m");
		 //CREATE CASES FOR THE DIFFERENT ORDERS
		 if (g == 1){
			 System.out.println("1 : "+answer);
			 System.out.println("\n");
			 System.out.println("2 : "+oanswer1);
			 System.out.println("\n");
			 System.out.println("3 : "+oanswer2);
			 System.out.println("\n");
		 }
		 if (g == 2){
			 System.out.println("1 : "+oanswer1);
			 System.out.println("\n");
			 System.out.println("2 : "+answer);
			 System.out.println("\n");
			 System.out.println("3 : "+oanswer2);
			 System.out.println("\n");
		 }
		 if (g == 3){
			 System.out.println("1 : "+oanswer1);
			 System.out.println("\n");
			 System.out.println("2 : "+oanswer2);
			 System.out.println("\n");
			 System.out.println("3 : "+answer);
			 System.out.println("\n");
		 }
		 int an = key.nextInt();
		 //int an = g;
		 if (an == g){
			 System.out.println((char)27 +"[32m"+"Correct ! " + (char)27 +"[0m");
			 won ++;
		 }
		 if (an != g){
			 System.out.println((char)27 +"[31m"+"Wrong" + (char)27+"[0m");
			 lost++;
		 }
		 rounds ++;
		 System.out.println((char)27 +"[2m" + "---------------------------------------------------------------------"+(char)27+"[0m");
		 }
		 double Wscore = won;
		 double loa = totallines;
		 double Fscore =(Wscore/loa)*100;
		 System.out.println("Score");
		 System.out.println((char)27 +"[32m"+"Won : "+ won + (char)27 +"[0m");
		 System.out.println((char)27 +"[31m"+"Lost : "+lost + (char)27 +"[0m");
		 System.out.println("number of questions = " + totallines);
		 if (Fscore > 50){
			 System.out.println((char)27 +"[32m"+"Final score : "+ Fscore +"%"+ (char)27 +"[0m");
		 }
		 if (Fscore < 50){
			 System.out.println((char)27 +"[31m"+"Final score : "+ Fscore +"%"+ (char)27 +"[0m");
		 }
			 try(FileWriter fz = new FileWriter (Score, true);
						BufferedWriter bz = new BufferedWriter (fz);
						PrintWriter out = new PrintWriter(bz)){
						out.print(LocalDateTime.now());
						out.print(" | "+ mcqName +" | " + Fscore + "%");
						out.print("\n");

			 System.out.println("You may view your score log in the file called 'score log'");
}
}
}
