public class ValidWordAbbr {
    Map<String, String> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for (String w : dictionary) {
            String abb = convertToUnique(w);
            if (map.containsKey(abb) && !map.get(abb).equals(w)) {
                map.put(abb, "");
            } else {
                map.put(abb, w);
            }
        }
    }

    public boolean isUnique(String word) {
        String abb = convertToUnique(word);
        return !map.containsKey(abb) || map.get(abb).equals(word);
    }
    
    public String convertToUnique(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
