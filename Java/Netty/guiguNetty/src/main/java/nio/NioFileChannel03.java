package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel03 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream("/Users/qihu/Downloads/test.txt")){
            FileChannel fileChannel = inputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            fileChannel.read(byteBuffer);

            try (FileOutputStream outputStream = new FileOutputStream("/Users/qihu/Downloads/retest.txt")) {
                FileChannel fileOutputChannel = outputStream.getChannel();

                byteBuffer.flip();
                fileOutputChannel.write(byteBuffer);

            }

        }
    }
}
