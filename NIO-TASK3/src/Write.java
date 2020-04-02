import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Write {
    private RandomAccessFile file;
    private Random rand = new Random();
    public Write(RandomAccessFile file) {
        this.file = file;
    }

    public void start() {
        MappedByteBuffer buf = null;
        try {
            buf = file.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 16);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            if(buf!= null && buf.getInt() == 0) {
                int num1 = rand.nextInt(100);
                int num2 = rand.nextInt(100);

                System.out.println(num1 + num2);
                buf.putInt(num1);
                buf.putInt(num2);
                buf.rewind();
                buf.putInt(1);
            }
            buf.rewind();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}