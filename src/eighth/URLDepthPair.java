package eighth;

import java.util.*;
import java.net.*;

public class URLDepthPair {
    private String URL;
    private int depth;

    public URLDepthPair(String URL, int depth) {
        this.URL = URL;
        this.depth = depth;
    }

    public String getURL() {
        return URL;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof URLDepthPair) {
            URLDepthPair o = (URLDepthPair)obj;
            return this.URL.equals(o.getURL());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}
