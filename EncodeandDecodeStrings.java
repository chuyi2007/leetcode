public class Codec {
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String coded = "";
        for (String s : strs) {
            coded += String.valueOf(s.length()) + "/" + s;
        }
        return coded;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (true) {
            int index = s.indexOf('/', i);
            if (index < 0) {
                break;
            }
            int length = Integer.parseInt(s.substring(i, index));
            decoded.add(s.substring(index + 1, index + length + 1));
            i = index + 1 + length;
        }
        return decoded;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
