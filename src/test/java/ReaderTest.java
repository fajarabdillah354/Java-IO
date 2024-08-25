import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {

    //membaca karakter menggunakan reader


    /** Reader
     * Reader adalah Input Stream untuk membaca resource berupa text
     * Dengan menggunakan Reader, kita bisa melakukan konversi otomatis dari numeric data menjadi character data
     * Untuk membaca data per character, kita bisa menggunakan method read()
     * Sedangkan untuk membaca langsung beberapa character, kita bisa gunakan method read(char[])
     * Cara penggunaannya mirip dengan InputStream
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Reader.html
     */


    @Test
    void testReaderWithoutArray() {
        //jika tidak menggunakan array maka data akan semakin membesar, ini menandakan data tidak valid karna yang harusnya 100 -> 1200

        Path path = Path.of("output.txt");
        try(Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            int counter = 0;
            while ((data = reader.read()) != -1){
                builder.append((char) data);
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        }catch (Exception exception){
            Assertions.fail();
        }
    }


    @Test
    void testReaderWithArray() {
        Path path = Path.of("output.txt");
        try(Reader reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            char[] data = new char[1024];
            int length;
            int counter = 0;
            while ((length = reader.read(data)) != -1 ){
                builder.append(data, 0, length);
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        }catch (Exception exception){
            Assertions.fail();
        }


    }
}
