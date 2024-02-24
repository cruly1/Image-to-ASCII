public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            Utils.help();
            return;
        }

        String name = args[0];

        if (name.equals("--help") || name.equals("-h")) {
            Utils.help();
            return;
        }

        if (name.equals("--version") || name.equals("-v")) {
            Utils.version();
            return;
        }

        ProcessImages.process();
    }
}
