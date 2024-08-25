import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class MemoryStreamTest {

    /** Memory Stream
     * Kadang ada kasus kita ingin membuat IO Stream, namun target resource nya tidak di file, misal hanya di variable di memory
     * Pada kasus seperti itu, kita bisa memanfaatkan Memory Stream yang tersedia di Java
     *
     */

    /** Contoh Memory Stream
     * ByteArrayInputStream, turunan InputStream yang mengambil datanya dari byte[]
     * ByteArrayOutputStream, turunan OutputStream yang menyimpan datanya di byte[] di memory
     * StringReader, turunan Reader yang mengambil data dari String
     * StringWriter, turunan Writer yang menyimpan data di String di memory
     */

    //ini jika tidak butuh disimpan dalam file hanya dalam variabel saja kita bisa gunakan seperti ini
    @Test
    void testMemory() {
        StringWriter writer = new StringWriter();
        for (int i = 0; i < 10; i++) {
            writer.write("hello world\n");
        }

        String content = writer.getBuffer().toString();
        System.out.println(content);
    }
}
