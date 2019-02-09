import java.util.* ;
// This program compares the overall scores of two candidates in terms of SAT, ACT amd GPA
public class Admit {
   public static void main (String[] args){
      Scanner console = new Scanner(System.in);
      intro();
      double score1 = calcScore(console, 1);
      double score2 = calcScore(console,2);
      compare(score1, score2);
      
   }
   //This method calculated the overall score.  
   public static double calcScore(Scanner console, int n){
      double exam1 = roundoff(satoract(console, n));
      double gpa1 = roundoff(gpa(console));
      double score1 = exam1 + gpa1;
      System.out.println("GPA score = " + gpa1);
      return score1; 
   }
  // this method prints the introductory lines of the program 
   public static void intro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant. For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
      
   }
   // this method asks for the users choice of SAT or ACT. 
   public static double satoract(Scanner console, int n) {
      System.out.println("Information for applicant #" + n + ":");
      System.out.print(" do you have 1) SAT scores or 2) ACT scores? ");
      double exam=0;
      double answer = console.nextInt();
      if (answer == 1){
         exam = roundoff(Sat(console));
      } else if (answer == 2){
         exam = roundoff(act(console));
      }
      System.out.println("exam score = " + exam);
      return exam;
   }
   // This method asks for user input of SAT scores. 
   public static double Sat(Scanner console) {
      System.out.print("SAT math? ");
      int math = console.nextInt();
      System.out.print("SAT critical reading? ");
      int cr = console.nextInt();
      System.out.print("SAT writing? ");
      int wr = console.nextInt();
      double score = satcal(math, cr, wr);
      return score;
   }
   // This method calculates the combined SAT score
    public static double satcal(double math, double cr, double wr){
      double score = ((2 * math) + cr + wr)/ 32.0 ;
      return score;
   }
   
   // Input for ACT scores
   public static double act(Scanner console) {
      System.out.print("ACT English? ");
      int eng = console.nextInt();
      System.out.print("ACT math? ");
      int maths = console.nextInt();
      System.out.print("ACT reading? ");
      int r = console.nextInt();
      System.out.print("ACT science? ");
      int science = console.nextInt();
      
      double score = actcal(maths, science, r,eng);
      return score;
   }
   // Calculated ACT score
    public static double actcal(double maths, double science, double r , double eng) {
      double score1 = (eng + 2 * maths + r + science)/ 1.8;
      return roundoff(score1);
   }
   //Asks for user GPA
      public static double gpa(Scanner console){
     System.out.print("overall GPA? ");
      double actual_gpa = console.nextDouble();
      System.out.print("max GPA? ");
      double max_gpa = console.nextDouble();
      System.out.print("Transcript Multiplier? ");
      double transcript_multiplier = console.nextDouble();
      
      double gpa = ( actual_gpa / max_gpa ) * 100 * transcript_multiplier ;
      return gpa ;
   }
   
  // Method to round off values 
   public static double roundoff(double x) {
      return Math.round(x * 10.0) / 10.0;
   }
   
   // method to compare applicants. 
   public static void compare(double score1 , double score2){
      System.out.println("First applicant overall score =  " + score1);
      System.out.println("Second applicant overall score = " + score2);
      
      if (score1 > score2){
         System.out.print("The first applicant seems to be better");
      }else if (score1 == score2){
         System.out.print("The two applicants seem to be equal");
      } else{
      System.out.print("The second applicant seems to be better"); 
      }
   }
}