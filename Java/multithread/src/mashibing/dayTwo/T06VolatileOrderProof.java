package mashibing.dayTwo;

public class T06VolatileOrderProof {
    public static void main(String[] args) {
        // Go to View -> byteCode
        //    NEW java/lang/Object
        //    DUP
        //    INVOKESPECIAL java/lang/Object.<init> ()V
        //    ASTORE 1
        Object o = new Object();
    }
}
