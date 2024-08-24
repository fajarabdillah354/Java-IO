import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class DirectoryManipulationTest {


    /**
        method : Files.createDirectories(path) -> Membuat banyak directory jika tidak ada
        method : Files.createDirectory(path) -> Membuat satu directory
        method : Files.newDirectoryStream(path) -> Membaca semua isi file di directory
        method : Files.isDirectory(path) -> Mengecek apakah path sebuah directory


     */

    //Directory atau Folder juga bisa dimanipulasi menggunakan class Files

    @Test
    @SneakyThrows
    void testDirectoryManipulation() {
        Path path = Path.of("fajar.txt");


        Assertions.assertTrue(Files.isDirectory(path));

        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));


    }
}
