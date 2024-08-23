import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClosebleTest {

    /** Closable Interface
     * Semua IO Stream di Java adalah turunan dari interface java.io.Closable, dimana terdapat method close() untuk menutup Resource yang sudah dibuka.
     * Hal ini agar tidak terjadi memory leak (kondisi dimana kita lupa menutup IO Stream sehingga data tidak bisa dihapus di memory oleh Java Garbage Collector)
     * @throws IOException
     */


    @Test
    void testClosableManual() throws IOException {

        Path path = Path.of("pom.xml");
        InputStream inputStream = null;

        try{
            inputStream = Files.newInputStream(path);
            //lakukan operasi yang diinginkan dengan variable inputStream untuk path pom.xml
        }catch (Exception exception){
            Assertions.fail(exception);
        }finally {
            if (inputStream != null){
                //jika mau hanya 1 yang ingin di manipulasi
                try {
                    inputStream.close();
                }catch (Exception exception){
                    Assertions.fail(exception);//jika lebih dari satu ini akan semakin panjang maka dari itu tidak direkomendasikan
                }
            }
        }

    }


    @Test
    void testClosebleWithTryWithResource() {

        /** Try with Resource
         * Seperti yang sudah dibahas di materi Java OOP, Try di Java memiliki fitur yang bisa digunakan untuk menutup Resource Closable secara otomatis
         * Dengan begitu, kita tidak perlu lagi melakukan close() IO Resource secara manual lagi seperti pada kode sebelumnya
         */


        //dengan menggunakan cara ini lebih simple, kita tidak masukan object Path ke dalam parameter InputStreamnya

        Path path = Path.of("pom.xml");
        try(InputStream inputStream = Files.newInputStream(path);
            InputStream inputStream2 = Files.newInputStream(path)
            // data3   ini kalo lebih dari 1
        ){
        }catch (Exception exception){
            Assertions.fail();
        }



    }
}
