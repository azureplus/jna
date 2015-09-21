import com.sun.jna.Library;
import com.sun.jna.Native;

public class HelloJNA
{
    public interface LgetLib extends Library
    {
        LgetLib INSTANCE = (LgetLib) Native.loadLibrary("/app/dev/jna/example/jna/libhellojna.o", LgetLib.class);

        long add(int a, long b);
    }

    public long add(int a, long b)
    {
        return LgetLib.INSTANCE.add(a, b);
    }

    public static long localAdd(int a, long b)
    {
        long s = 0;
        for (int i = 0; i < b; i++)
        {
            s += a;
        }
        return s;
    }

    public static void main(String[] args)
    {
        System.setProperty("java.library.path", "/app/dev/jna/example/jna");
        long size = 100000000000000000l;
        long time = System.currentTimeMillis();
        HelloJNA ts = new HelloJNA();
        long c = ts.add(1, size);
        System.out.println("10+20=" + c);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        c = localAdd(1, size);

        System.out.println(System.currentTimeMillis() - time);
        System.out.println("10+20=" + c);
    }
}