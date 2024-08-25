import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathTest {
    /** Path
     *  Sejak Java 7, dikenalkan class Path yang bisa digunakan untuk mengakses resource sebagai pengganti class File
     *  Path adalah sebuah interface, untuk membuat Path, kita bisa gunakan static method Path.of(pathname)
     *  Path terdapat di package java.nio.file
     *  https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/file/Path.html
     */


    @Test
    void testCreatePath() {

        Path path = Path.of("file.txt");//ini tidak berarti file otomatis dibuat, hanya object di java bukan representasi nyata

        Assertions.assertEquals("file.txt", path.toString());
        Assertions.assertFalse(path.isAbsolute());//bentuk pengambilan file.txt bukan absolut,karna menggunakan assertFalse maka true
    }

    @Test
    void testUsingPath() {
        Path path = Path.of("pom.xml");

        Assertions.assertEquals("pom.xml",path.toString());
        Assertions.assertFalse(path.isAbsolute());
        /** Files class
         * kita bisa menggunakan behavior yang ada di class File di dalam interface Path dengan bantuan dari class Files
         * karna method yand ada di dalam interface Path terbatas, kita tetep bisa mengolah file dengan bantuan class Files untuk interface Path, sehingga kita bisa dapat menggunakan method yang ada di class File
         */

        Assertions.assertTrue(Files.exists(path));




    }
}
