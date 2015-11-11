/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        char[] buff = new char[4];
        while (ptr < n) {
            int x = read4(buff);
            if (x == 0) {
                break;
            }
            for (int i = 0; i < x && ptr < n; ++i) {
                buf[ptr++] = buff[i];
            }
        }
        return ptr;
    }
}
