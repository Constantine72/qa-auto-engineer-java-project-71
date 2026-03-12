package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "app",
        description = "Test CLI application",
        mixinStandardHelpOptions = true
)
public class App implements Runnable {


        @Override
        public void run() {
            System.out.println("Hello World!");
        }

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
