import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessTheMovie {
   public static void main(String[] args)
   {
       String filePath = "words.txt";
       ArrayList<String>movies = new ArrayList<>();
       try(BufferedReader reader = new BufferedReader(new FileReader(filePath)))
       {
           String line;
           while ((line = reader.readLine())!=null)
           {
               movies.add(line.trim());
           }
       }
    catch(FileNotFoundException e)
    {
        System.out.println("Could not find file.");
    }
       catch (IOException e)
       {
           System.out.println("Something went wrong.");
       }
       System.out.println(movies);
       Random random = new Random();
       String name = movies.get(random.nextInt(movies.size()));
       System.out.println("The choosen movie is " + name);
       // initial program
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
       int limit = name.length()/2;
       while (wrongGuesses <= limit && correctGuesses<name.length())
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
              if(wrongGuesses<=6)
              System.out.println(getArt(wrongGuesses));
              else
                  System.out.println(getArt(6));
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

   static String getArt(int wrongGuesses) {
       return switch (wrongGuesses) {
           case 0 -> """
                   
                   
                   
                   """;
           case 1 -> """
                    o
                   
                   
                   """;
           case 2 -> """
                    o
                    | 
                   
                   """;
           case 3 -> """
                    o
                   /| 
                   
                   """;
           case 4 -> """
                     o
                    /|\\ 
                   
                   """;
           case 5 -> """
                     o
                    /|\\ 
                    /
                   """;
           case 6 -> """
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
