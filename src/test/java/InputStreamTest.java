import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class InputStreamTest {

    /** Input Stream
     * InputStream merupakan base Interface yang digunakan untuk membaca Resource
     * InputStream menggunakan numeric data, sehingga jika kita ingin membaca data text, kita harus konversi menjadi data numeric terlebih dahulu
     * Sangat disarankan menggunakan InputStream pada kasus data yang non Text, seperti gambar, video, dan lain-lain
     * Jika data Text, lebih disarankan menggunakan Reader karena bisa langsung menggunakan tipe data Character
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/InputStream.html
     */



    /** Membaca Data
     * Untuk membaca data di InputStream, kita bisa gunakan method dengan awalan read()
     * pada kasus data yang banyak, agar lebih cepat, kita bisa menggunakan method read(bytes) agar bisa membaca data sekaligus sebanyak panjang array bytes
     * Jangan gunakan readAllBytes() pada kasus data besar, karena akan disimpan seluruh datanya di memory
     * Method read() akan mengembalikan -1 jika sudah tidak ada data yang bisa dibaca lagi
     */

    @Test
    void testRead() {

        /**
         * untuk membaca file 1 persatu menggunakan method read(), tanpa parameter array byte
         * jika menggunakan read maka akan melakukan iterasi 1 per 1 pada file yang akan dibaca, sehingga menyebabkan program agak lama
         */

        Path path = Path.of("pom.xml");

        try(InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            while ((data = inputStream.read()) != -1){
                builder.append((char) data);
            }
            System.out.println(builder.toString());
        }catch (Exception exception){
            Assertions.fail();
        }
    }

    @Test
    void testBytesRead() {



        //jika file berukuran besar kita bisa menggunakan byte[]

        Path path =Path.of("pom.xml");
        try(InputStream stream = Files.newInputStream(path)) {

            StringBuilder builder = new StringBuilder();
            byte[] buffer = new byte[1024];//sekali baca 1024, jadi lebih cepat
            int lenght;
            int counter = 0;

            //ketika read parameter buffer akan dikirim kan datanya,sehingga data ada di dalam buffer, dan return value berubah jadi length
            while ((lenght = stream.read(buffer)) != -1){

                //konversi ke new String karna berupa Bytes, dari index ke 0 sampai panjang buffernya
                builder.append(new String(buffer, 0, lenght));
                counter++;
            }
            System.out.println(builder.toString());
            log.info(" {} ",builder);
            System.out.println(counter);
        }catch (Exception exception){
            Assertions.fail(exception);
        }
    }



}
