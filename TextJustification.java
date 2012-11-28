public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        LinkedList<String> line = new LinkedList<String>();
        ArrayList<String> results = new ArrayList<String>();
        for(int i = 0; i < words.length; ++i){
            //add one right space to count
            count += words[i].length() + 1;
            //line
            line.offer(words[i]);
            
            //if this line has more chars than L
            if(count >= L){
                //if last word exceeds, remove it
                if(count - 1 > L){
                    //remove last word from line
                    count -= line.pollLast().length() + 1;
                    --i;
                }
                //edge case, if line only contains one word
                if(line.size() == 1){
                    String result = "";
                    result += line.poll() + fillSpace(L - count + 1);
                    results.add(result);
                }
                //normal case, where two or more words exists
                else{
                    //total space left without consider the one space for count
                    int totalSpace = L - count + 1;
                    //average space per slot
                    int ave = totalSpace/(line.size() - 1);
                    //remaining space
                    int remain = totalSpace - ave * (line.size() - 1);
                    String result = "";
                    while(line.size() > 1){
                        //space size, left should have more
                        int size = remain-->0?ave+1:ave;
                        result += line.poll() + fillSpace(size + 1);
                    }
                    //last word in the line
                    result += line.poll();
                    results.add(result);
                }
                count = 0;
            }
        }
        //last line
        if(line.peek() != null){
            String result = "";
            int size = L;
            while(line.peek() != null){
                size -= line.peek().length() + 1;
                result += line.poll() + " ";
            }
            result += fillSpace(size);
            results.add(result);
        }
        return results;
    }
    
    public String fillSpace(int size){
        char[] space = new char[size];
        Arrays.fill(space, ' ');
        return new String(space);
    }
}