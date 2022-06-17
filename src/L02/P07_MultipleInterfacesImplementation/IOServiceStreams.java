package L02.P07_MultipleInterfacesImplementation;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOServiceStreams implements OutputService, InputService{

    private final Scanner input;
    private final PrintStream output;

    public IOServiceStreams(InputStream inputStream, PrintStream outputStream) {
        this.input = new Scanner(inputStream);
        this.output = outputStream;
    }

    @Override
    public String readString() {
        return this.input.nextLine();
    }

    @Override
    public void outputString(String s) {
        output.println(s);
    }
}
