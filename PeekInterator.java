// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer cache;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.cache = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer nextValue = null;
        if (cache != null) {
            nextValue = cache;
            cache = null;
        } else {
            nextValue = iterator.next();
        }
        return nextValue;
    }

    @Override
    public boolean hasNext() {
        if (cache != null) {
            return true;
        } else {
            return iterator.hasNext();
        }
    }
}
