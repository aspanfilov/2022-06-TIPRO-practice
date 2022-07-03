package L04.Ch1_IO.P05_DataIOStream;

import java.io.*;

public class DataIOStream {
    public static void main(String[] args) {
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("Data.bin"));
            DataInputStream inputStream = new DataInputStream(new FileInputStream("Data.bin"))) {

            outputStream.writeBoolean(true);
            outputStream.writeByte(5);
            outputStream.writeShort(466);
            outputStream.writeInt(1_000_000);
            outputStream.writeLong(9_000_000_000L);
            outputStream.writeFloat(4.123F);
            outputStream.writeDouble(123.123D);

            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readByte());
            System.out.println(inputStream.readShort());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readDouble());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
