import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {
    /** Print Stream
     * Salah satu turunan dari Output Stream yang sering kita gunakan secara tidak sadar adalah Print Stream
     * Print Stream adalah Output Stream yang bisa menerima berbagai jenis data, dan secara otomatis melakukan konversi ke numeric data yang dibutuhkan oleh Output Stream
     * Saat kita menggunakan System.out, itu sebenarnya adalah object dari Print Stream
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/PrintStream.html
     */


    //dengan menggunakan PrintStream bisa menerima data apapun

    @Test
    void testPrintStreamWithoutFile() {

        // System.out.println itu sebenarnya adalah bagian dari PrintStream
        PrintStream printStream = System.out;
        printStream.println("hello");
        printStream.println("hello");
        printStream.println("hello");

    }
    //kita juga bisa membuat PrintStream yang datanya disimpan dalam file


    @Test
    void testPrintStreamFile() {
        Path path = Path.of("testPrint.txt");
        try(OutputStream outputStream = Files.newOutputStream(path);//dasarnya kita akan menggunakan OutputStream
            PrintStream printStream = new PrintStream(outputStream)) {//PrintStream sebagai helper
            printStream.println("fajar");
            printStream.println("galang");
            printStream.println("sandi");
        }catch (IOException exception){
            Assertions.fail(exception);
        }

    }
}
