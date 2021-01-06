package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannel03 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream("/Users/qihu/Downloads/test.txt"); FileOutputStream outputStream = new FileOutputStream("/Users/qihu/Downloads/retest.txt")){
            try (FileChannel fileInputChannel = inputStream.getChannel(); FileChannel fileOutputChannel = outputStream.getChannel()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                while (true) {
                    //Very important step to clear position to 0, in case the output file is very big -> position == limit
                    byteBuffer.clear();
                    int index = fileInputChannel.read(byteBuffer);

                    if (index == -1) {
                        break;
                    }
                    byteBuffer.flip();
                    fileOutputChannel.write(byteBuffer);
                }

            }
        }
    }
}
