import javax.sound.sampled.*;
import java.io.File;
//import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath ="C:\\Users\\osaze\\IdeaProjects\\untitled1\\src\\Hanging Motionless - Mark Karan, Scott Guberman, Angeline Saris, Jeremy Hoenig.wav";
        File file = new File(filePath);
        try(Scanner sc= new Scanner(System.in);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file)) {
          String response=" ";
            Clip clip =  AudioSystem.getClip();
            clip.open(audioInputStream);
            while(!response.equals("Q")){

                //System.out.println("No problems detected");
                //clip.start()

                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter your choice: ");
                response =sc.next().toUpperCase();

                switch (response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid Choice");

                }

            }

        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        }catch(UnsupportedAudioFileException e){
            System.out.println("Audio File not be supported!");
        }catch(LineUnavailableException e){
            System.out.println("Line unavailable!");
        } catch(IOException e){
            System.out.println("Something went wrong");
        }finally{
            //sc.close();
            System.out.println("Thanks for listening!");
        }

    }
}
