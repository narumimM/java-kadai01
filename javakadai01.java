import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class javakadai01 {
    public static void main(String args[]) {

    try(BufferedReader reader =Files.newBufferedReader(
        Paths.get(".","Test1,","scores.csv"))){
        String line ="";
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
