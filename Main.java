import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String location = "src\\Seagull - Telecasted (1).wav"; // Ensure the path is correct
        File file = new File(location);

        try (AudioInputStream aud = AudioSystem.getAudioInputStream(file)) {
            System.out.println("Audio file successfully loaded.");
            Clip clip = AudioSystem.getClip();
            clip.open(aud);

            Scanner scanner = new Scanner(System.in);
            String response = " ";

            while (!response.equals("Q")) {
                System.out.println("Enter P for Play");
                System.out.println("Enter S for Stop");
                System.out.println("Enter R for Reset");
                System.out.println("Enter Q for Quit");
                System.out.println("Enter Choice !");
                response = scanner.nextLine().toUpperCase();

                if (response.equals("P")) {
                    clip.start();
                } else if (response.equals("S")) {
                    clip.stop();
                } else if (response.equals("R")) {
                    clip.setFramePosition(0);
                } else if (response.equals("Q")) {
                    clip.close(); // Stop and release resources before quitting
                } else {
                    System.out.println("Invalid input!");
                }
            }

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Not Supported !");
        } catch (IOException e) {
            System.out.println("Something went off");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource");
        } finally {
            System.out.println("Bye Dude");
        }
    }
}
