// simple solution
public class ZigzagIterator {
    Iterator<Integer> v1;
    Iterator<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1.iterator();
        this.v2 = v2.iterator();
    }

    public int next() {
        if (v1.hasNext()) {
            Iterator<Integer> tmp = v2;
            v2 = v1;
            v1 = tmp;
        }
        return v2.next();
    }

    public boolean hasNext() {
        return v1.hasNext() || v2.hasNext();
    }
}

// extendable to k iterators
public class ZigzagIterator {
    Iterator<Integer>[] iterators;
    int pos;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new Iterator[2];
        iterators[0] = v1.iterator();
        iterators[1] = v2.iterator();
        pos = 0;
    }

    public int next() {
        int val = iterators[pos].next();
        pos = (pos + 1) % iterators.length;
        return val;
    }

    public boolean hasNext() {
        if (iterators[pos].hasNext()) {
            return true;
        }
        for (int i = pos + 1; i < iterators.length; ++i) {
            if (iterators[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        for (int i = 0; i < pos; ++i) {
            if (iterators[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
