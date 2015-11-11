/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    char[] buff = new char[4];
    int globalPtr = 0;
    int globalBuffCount = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (globalPtr == 0) {
                globalBuffCount = read4(buff);
            }
            if (globalBuffCount == 0) {
                break;
            }
            while (globalPtr < globalBuffCount && ptr < n) {
                buf[ptr++] = buff[globalPtr++];
            }
            if (globalPtr == globalBuffCount) {
                globalPtr = 0;
            }
        }
        return ptr;
    }
}
