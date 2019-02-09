//Soham Ghose 
//CSE 142 
// 10-5-16
// TA: Charles Mihran
//Assingment1 
//this programme will produce a song with several redundant lines as well as self made phrase. 
public class Song{
public static void main(String[] args){
para1();
para2();
para3();
para4();
para5();
para6();
end();
}


public static void para1(){
phrase1() ;
System.out.println("fly.");
phrase2();
System.out.println();}
public static void para2(){
phrase1();
System.out.println("spider,"); 
System.out.println("That wriggled and iggled and jiggled inside her."); 
phrase3();
phrase2() ;
System.out.println();}
public static void para3(){
phrase1();
System.out.println("bird,") ;
System.out.println("How absurd to swallow a bird."); 
phrase4();
phrase2() ;
System.out.println();}
public static void para4(){
phrase1();
System.out.println("cat,") ;
System.out.println("Imagine that to swallow a cat."); 
phrase5();
phrase2() ;
System.out.println();}
public static void para5(){
phrase1();
System.out.println("dog,"); 
System.out.println("What a hog to swallow a dog.") ;
phrase6();
phrase2() ;
System.out.println();}
public static void para6(){
phrase1(); 
System.out.println("lion,"); 
System.out.println("Wasnt even tryin' to swallow the lion."); 
phrase7();
phrase2(); 
System.out.println();}
public static void end(){
System.out.println("There was an old woman who swallowed a horse,");
System.out.println("She died of course.");}


public static void phrase1()
{System.out.print("There was an old woman who swallowed a ");
}

public static void phrase2()
{ System.out.println("I don't know why she swallowed that fly,");
  System.out.println("Perhaps she'll die.");}
 
 
public static void phrase3()
{
System.out.println("She swallowed the spider to catch the fly,");}

public static void phrase4()
{System.out.println("She swallowed the bird to catch the spider,");
phrase3();
}

public static void phrase5()
{ System.out.println("She swallowed the cat to catch the bird,");
phrase4();
}
public static void phrase6()
{System.out.println("She swallowed the dog to catch the cat,");
phrase5(); }

 
public static void phrase7()
{System.out.println("She swallowed the lion to catch the dog,");
phrase6(); }

 
 
 
 
 
 }