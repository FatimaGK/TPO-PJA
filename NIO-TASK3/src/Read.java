import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Read {
    private RandomAccessFile file;
    public Read(RandomAccessFile file) {
        this.file = file;
    }

    public void start() {
        FileChannel fileChannel = file.getChannel();
        MappedByteBuffer buf = null;
        try {
            buf  = fileChannel.map(
                    FileChannel.MapMode.READ_WRITE,
                    0,
                    16
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            if( buf.getInt() == 1) {
                int sum = buf.getInt() + buf.getInt();
                System.out.println(sum);
                buf.rewind();
                buf.putInt(0);
            }
            buf.rewind();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}