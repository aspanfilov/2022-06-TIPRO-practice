package L02.P07_MultipleInterfacesImplementation;

public class Main {

    public static void main(String[] args) {
        OutputService outputService = new IOServiceStreams(System.in, System.out);
        InputService inputService = new IOServiceStreams(System.in, System.out);

        String s = inputService.readString();

        outputService.outputString("Была введена строка: ");
        outputService.outputString(s);
    }

}
