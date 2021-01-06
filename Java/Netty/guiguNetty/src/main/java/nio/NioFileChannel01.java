package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "Hello, stranger";
        // create an output stream -> channel
        /*try (FileOutputStream fileOutputStream = new FileOutputStream("/home/qih/test.txt");) {
            // Get fileChannel from the fileOutputStream
            // The real class is FileChannelImp
            FileChannel fileChannel = fileOutputStream.getChannel();

            // Create one byteBuffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            byteBuffer.put(str.getBytes());

            // flip to read mode (position reset to 0)
            byteBuffer.flip();

            // write to the channel
            fileChannel.write(byteBuffer);
        }*/

        // Channel is inside the output stream
        try (FileOutputStream outputStream = new FileOutputStream("/Users/qihu/Downloads/test.txt")) {
            try (FileChannel fileChannel = outputStream.getChannel()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));

                byteBuffer.flip();

                fileChannel.write(byteBuffer);
            }
        }
    }
}
