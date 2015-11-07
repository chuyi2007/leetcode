public class Vector2D {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
        j = null;
    }

    public int next() {
        return j.next();
    }

    public boolean hasNext() {
        // in case some of the list is empty
        while (i.hasNext() && (j == null || !j.hasNext())) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
