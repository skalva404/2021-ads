package kalva.learnings.ads.pds.qf;

public class Utils {

    public static short getQuotient(Object obj) {
        int hashcode = obj.hashCode() >> 16;
        hashcode = Math.abs(hashcode);
        return (short) hashcode;
    }

    public static short getRemainder(Object obj) {
        return (short) obj.hashCode();
    }

    public static int getIndex(Object obj, int size) {
        return getQuotient(obj) % size;
    }
}
