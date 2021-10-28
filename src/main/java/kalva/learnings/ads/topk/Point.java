package kalva.learnings.ads.topk;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}