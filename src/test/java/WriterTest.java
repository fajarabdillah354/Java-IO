import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {
    /** Writer
     * Writer merupakan base Interface yang digunakan untuk menulis ke Resource untuk data text
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Writer.html
     */

    /** Menulis Data
     * Untuk menulis data di Writer, kita bisa gunakan method dengan awalan write()
     * Kita bisa mengirim data dalam bentuk char int, char[] atau String pada method write()
     */

    @Test
    void testWriter() {
        Path path = Path.of("writer.txt");
        try(Writer writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 100; i++) {
                writer.write("write Hello\n");
                writer.flush();//untuk menyimpan 1 persatu perulangan dalam file target(ini sama seperti OuputStream)
            }
        }catch (Exception exception){
            Assertions.fail();
        }

    }
}
