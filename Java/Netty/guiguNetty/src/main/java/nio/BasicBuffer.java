package nio;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {

        // introduction for buffer
        // create a buffer that can store 5 integers
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // insert data to the intBuffer
        intBuffer.put(10);
        intBuffer.put(11);
        intBuffer.put(12);
        intBuffer.put(13);
        intBuffer.put(14);

        // read data
        // switch to read mode
        intBuffer.flip();

        // Can change the read position
        //intBuffer.position(3);
        // Can change destination
        //intBuffer.limit(4);
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
