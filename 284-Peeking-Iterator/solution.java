// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer peek = null;
    private Iterator<Integer> it = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    if (it.hasNext()) {
	        peek = it.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer next = peek;
	    if (it.hasNext()) {
	        peek = it.next;
	    }
	    
	    return next;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}