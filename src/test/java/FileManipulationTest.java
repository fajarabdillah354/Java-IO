import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManipulationTest {

    /** Manipulasi File
     * Seperti yang dijelaskan di awal, membuat File atau Path bukan berarti file otomatis terbuat, itu hanya object di Java, bukan representasi nyata di File System
     * Namun dengan menggunakan class Files, kita bisa melakukan manipulasi file seperti membuat, menghapus atau membacanya
     * @throws IOException
     */


    /** Manipulasi File
        method : Files.createFile(path) -> Membuat file
        method : Files.delete(path) / Files.deleteIfExists(path) -> Menghapus file / jika ada
        method : Files.copy(source, target) -> Menyalin file
        method : Files.move(source, target) -> Memindahkan file
     * @throws IOException
     */

    @Test
    void testCreateFile() throws IOException {
        Path path = Path.of("file.txt");
        Files.createFile(path);


        //check file if exist3
        Assertions.assertTrue(Files.exists(path));


        //delete file
        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));

    }
}
