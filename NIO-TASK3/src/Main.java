import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import static java.nio.file.AccessMode.READ;
import static java.nio.file.AccessMode.WRITE;

public class Main {

//    private static String READ = "read";
//    private static String WRITE = "write";

    public static void main(String[] args) {

        RandomAccessFile ramFile = null;
        try {
            ramFile = new RandomAccessFile(new File("ffile"), "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RunningMod mode;
        if (args.length == 0) throw new NullPointerException(" mode not specified");
        else mode = RunningMod.getMode(args[0]);


//        if (mode!=0)
//        if (mode.equalsIgnoreCase(WRITE_MODE))
//        //--------------------------
        //        String mode = args[0];

//        if (mode.equals(WRITE)) {
//            Write write = new Write(ramFile);
//            write.start();
//        } else if (mode.equals(READ)) {
//            Read read = new Read(ramFile);
//            read.start();
//        } else {
//            throw new IllegalArgumentException("Wrong mode. Application exits.");
//            //---------------------
//        }
        switch (mode) {
            case WRITE:
                Write writer = new Write(ramFile);
                writer.start();
                break;
            case READ:
                Read reader = new Read(ramFile);
                reader.start();
                break;
            case EXIT:
                break;
            default:
                throw new IllegalArgumentException("wrong mod!");
        }
    }
}
