import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheMovie {
   public static void main(String[] args)
   {
       String name = "notebook";
       Scanner scanner = new Scanner(System.in);
       ArrayList<Character>wordGame = new ArrayList<>();
       int wrongGuesses = 0, correctGuesses = 0;
       for(int i = 0; i<name.length(); i++)
       {
          wordGame.add('_');
       }
       System.out.print("Word : ");
       for(char c : wordGame)
       {
           System.out.print(c + " ");
       }
       System.out.println();
      // int noOfGuesses = 8;
       while (wrongGuesses <= 6 && correctGuesses<name.length())
       {
           System.out.print("Enter your guess : ");
          String input = scanner.next().toLowerCase();
          char c = input.charAt(0);
          int idx = name.indexOf(c);
          if(idx >= 0)
          {
              System.out.println("Correct Guess!\n");
              for(int i = 0; i<name.length(); ++i)
              {
                  if(name.charAt(i) == c)
                  {
                      wordGame.set(i,c);
                      correctGuesses++;
                  }
              }

              for(char ch : wordGame)
              {
                  System.out.print(ch + " ");
              }
              System.out.println();
          }
          else
          {
              System.out.println("Ahh, wrong guess!");
              wrongGuesses++;
              System.out.println("You have made "+wrongGuesses+" wrong guesses.");
              System.out.println(getArt(wrongGuesses));
          }

       }
       if (correctGuesses >= name.length())
       {
           System.out.println("You guessed the MOVIE. Hurrahhh!!!!");
       }
       else
       {
           System.out.println("OOPS!!!You crossed the limit for wrong guesses, you lose the GAME. Sorry :(((");
           System.out.println(getArt(6));
       }
       //System.out.println(getArt(wrongGuesses));
       scanner.close();
   }
   static String getArt(int wrongGuesses)
   {
      return switch (wrongGuesses)
       {
           case 0 -> """
                     
                     
                     
                     """;
           case 1 -> """
                      o
                    
                     
                     """;
           case 2-> """
                     o
                     | 
                     
                    """;
           case 3-> """
                     o
                    /| 
                     
                    """;
           case 4->"""
                     o
                    /|\\ 
                     
                   """;
           case 5->"""
                     o
                    /|\\ 
                    /
                   """;
           case 6->"""
                     o
                    /|\\ 
                    / \\
                   """;
           default -> """
                      something went wrong :(
                      """;
       };
   }
}
