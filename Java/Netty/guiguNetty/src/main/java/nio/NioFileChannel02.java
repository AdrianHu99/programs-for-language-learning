package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel02 {
    public static void main(String[] args) throws IOException {
        /*try (FileInputStream fileInputStream = new FileInputStream("/home/qih/test.txt")) {
            FileChannel fileChannel = fileInputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            fileChannel.read(byteBuffer);

            System.out.println(new String(byteBuffer.array()));
        }*/

        try (FileInputStream inputStream = new FileInputStream("/Users/qihu/Downloads/test.txt")) {
            try (FileChannel fileChannel = inputStream.getChannel()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                fileChannel.read(byteBuffer);

                System.out.println(new String(byteBuffer.array()));
            }
        }

    }
}
