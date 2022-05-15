// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> now;
    int count = 0;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    now = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        List<Integer> list = new ArrayList<>();
        while (now.hasNext()){
            list.add(now.next());
        }
        now = list.iterator();
        return list.get(0);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        count++;
        return now.next();
	}
	
	@Override
	public boolean hasNext() {
	    return now.hasNext();
	}
}