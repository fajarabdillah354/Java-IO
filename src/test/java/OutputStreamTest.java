import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {


    /** Output Stream
     * OutputStream merupakan base Interface yang digunakan untuk menulis ke Resource
     * OutputStream menggunakan numeric data, sehingga jika kita ingin menyimpan data text, kita harus konversi menjadi data numeric terlebih dahulu
     * Sangat disarankan menggunakan OutputStream pada kasus data yang non Text, seperti gambar, video, dan lain-lain
     * Jika data Text, lebih disarankan menggunakan Writer karena bisa langsung menggunakan tipe data Character
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/OutputStream.html
     */


    /** Menulis Data
     * Untuk menulis data di OutputStream, kita bisa gunakan method dengan awalan write()
     * Kita bisa mengirim data dalam bentuk byte int, atau byte[] pada method write()
     */


    /** Flush
     * Secara default, pada saat kita melakukan close() OutputStream, data yang kita tulis akan di simpan secara permanen di target Resource
     * Namun pada kasus kita banyak menulis data, sangat disarankan menggunakan method flush() untuk memaksa OutputStream untuk menyimpan data secara permanen ke target Resource
     * Hal ini untuk waspada ketika terjadi system crash yang menyebabkan aplikasi berhenti, namun kita belum melakukan close() OutputStream, yang bisa menyebabkan data belum disimpan secara permanen ke Resource
     */


    @Test
    void testOutput() {

        Path path = Path.of("output.txt");
        try(OutputStream outputStream = Files.newOutputStream(path)) {
            for (int i = 0; i < 100; i++) {
                outputStream.write("Hello World\n".getBytes());
                outputStream.flush();//untuk menyimpan data disetiap perulangan yang terjadi
            }
        }catch (Exception exception){
            Assertions.fail();
        }
        
    }
}
