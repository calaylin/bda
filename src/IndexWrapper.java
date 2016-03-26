// Taken from http://whyjava.wordpress.com/2010/05/04/finding-all-the-indexes-of-a-whole-word-in-a-given-string-using-java/

public class IndexWrapper {
 
    private int start;
    private int end;
 
    public IndexWrapper(int start, int end) {
        this.start = start;
        this.end = end;
    }
 
    public int getEnd() {
        return end;
    }
 
    public int getStart() {
        return start;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + end;
        result = prime * result + start;
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IndexWrapper other = (IndexWrapper) obj;
        if (end != other.end)
            return false;
        if (start != other.start)
            return false;
        return true;
    }
 
}