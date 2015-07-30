package com.updateimpact.report;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * http://stackoverflow.com/questions/6717165/how-can-i-zip-and-unzip-a-string-using-gzipoutputstream-that-is-compatible-with
 */
public class ZIP {
    public static String compress(String string) throws IOException {
        byte[] blockcopy = ByteBuffer
                .allocate(4)
                .order(java.nio.ByteOrder.LITTLE_ENDIAN)
                .putInt(string.length())
                .array();
        ByteArrayOutputStream os = new ByteArrayOutputStream(string.length());
        GZIPOutputStream gos = new GZIPOutputStream(os);
        gos.write(string.getBytes("UTF-8"));
        gos.close();
        os.close();
        byte[] osba = os.toByteArray();
        byte[] compressed = new byte[4 + osba.length];
        System.arraycopy(blockcopy, 0, compressed, 0, 4);
        System.arraycopy(osba, 0, compressed, 4, osba.length);
        return Base64.encodeBase64String(compressed);
    }

    public static String decompress(String compressedStr) throws IOException {
        byte[] compressed = Base64.decodeBase64(compressedStr);
        final int BUFFER_SIZE = 512;
        ByteArrayInputStream is = new ByteArrayInputStream(compressed, 4, compressed.length - 4);
        GZIPInputStream gis = new GZIPInputStream(is, BUFFER_SIZE);
        StringBuilder string = new StringBuilder();
        byte[] data = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = gis.read(data)) != -1) {
            string.append(new String(data, 0, bytesRead, "UTF-8"));
        }
        gis.close();
        is.close();
        return string.toString();
    }
}
