import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {

    /** Object Stream
     * Untuk menyimpan data object, kita bisa menggunakan ObjectInputStream
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html
     * Dan untuk mengambil data object, kita bisa menggunakan ObjectOutputStream
     * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html
     */


    @Test
    void testSavePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("fajar");
        Path path = Path.of("fajar.person");

        try(OutputStream outputStream = Files.newOutputStream(path);
            ObjectOutputStream stream = new ObjectOutputStream(outputStream)) {//sebagai helper untuk object ke numerik data
            stream.writeObject(person);
            stream.flush();
        }catch (IOException exception){
            Assertions.fail();
        }
    }

    @Test
    void testGetPerson() {
        Path path = Path.of("fajar.person");
        try(InputStream inputStream = Files.newInputStream(path);
            ObjectInputStream stream = new ObjectInputStream(inputStream)) {
            Person person =(Person) stream.readObject();

            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("fajar",person.getName());
        }catch (IOException | ClassNotFoundException exception){
            Assertions.fail();
        }


    }
}
