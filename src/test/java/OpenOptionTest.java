import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptionTest {


    /** Java Bean
     * Saat kita membuat program Java, kita sering membuat data dalam bentuk Java Bean (class dengan getter dan setter)
     * Pada kasus kita ingin menyimpan data object tersebut ke file, jika kita menggunakan Input/Output Stream, maka akan sangat menyulitkan, karena kita harus lakukan secara manual, dan melakukan konversi secara manual
     * Untungnya Java memiliki fitur Object Stream, dimana kita bisa menyimpan/membaca data Java Object dari file
     */

    /** Serializable
     * Salah satu syarat ketika ingin membuat Java Bean Class yang bisa disimpan kedalam file hasil objectnya, kita harus membuat Java Bean Class turunan dari interface Serializable
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html
     * Setelah itu, kita harus memberi tahu versi dari class tersebut dengan menggunakan static attribute static final long serialVersionUID, dimana berisikan versi dari Java Class nya
     * Setiap kita melakukan perubahan di class nya, misal menambahkan attribute, menghapus attribute, maka kita harus mengubah versi nya, agar tidak terjadi masalah ketika melakukan Object Stream
     */

    /** Open Option
     * Saat kita membuat IO Stream menggunakan class Files, terdapat parameter diakhirnya yaitu OpenOption
     * OpenOption merupakan opsi tambahan yang ingin kita lakukan pada proses IO Stream
     * OpenOption merupakan sebuah interface, implementasinya kita bisa menggunakan enum StandardOpenOption
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/OpenOption.html
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/StandardOpenOption.html
     */

    @Test
    void testAppend() {
        Path path = Path.of("append.txt");
        // JIKA FILE BELUM ADA maka akan dibuat, lalu setelah itu jika ada penambahan input baru maka data akan di append/ditambah ke data yang paling akhir
        try(Writer writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write("hello fajar\n");
            writer.flush();
        }catch (Exception exception){
            Assertions.fail();
        }

    }
}
