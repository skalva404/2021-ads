package kalva.learnings.ads.companies.google;

public class Region {

    public static enum DIRECTION {
        SW, NW, NE, SE;
    }

    private float x1;
    private float y1;
    private float x2;
    private float y2;

    public Region(float x1, float y1, float x2, float y2) {
        if (x1 >= x2 || y1 >= y2)
            throw new IllegalArgumentException("(x1,y1) should be lesser than (x2,y2)");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Region getQuadrant(DIRECTION direction) {
        float quadrantWidth = (this.x2 - this.x1) / 2;
        float quadrantHeight = (this.y2 - this.y1) / 2;

        // 0=SW, 1=NW, 2=NE, 3=SE
        switch (direction) {
            case SW:
                return new Region(x1, y1, x1 + quadrantWidth, y1 + quadrantHeight);
            case NW:
                return new Region(x1, y1 + quadrantHeight, x1 + quadrantWidth, y2);
            case NE:
                return new Region(x1 + quadrantWidth, y1 + quadrantHeight, x2, y2);
            case SE:
                return new Region(x1 + quadrantWidth, y1, x2, y1 + quadrantHeight);
        }
        return null;
    }

    public boolean containsPoint(Point point) {
        // Consider left and top side to be inclusive for points on border
        return point.getX() >= this.x1
                && point.getX() < this.x2
                && point.getY() >= this.y1
                && point.getY() < this.y2;
    }

    public boolean doesOverlap(Region that) {
        // Is test region completely to left of my region?
        if (that.getX2() < this.getX1()) {
            return false;
        }
        // Is test region completely to right of my region?
        if (that.getX1() > this.getX2()) {
            return false;
        }
        // Is test region completely above my region?
        if (that.getY1() > this.getY2()) {
            return false;
        }
        // Is test region completely below my region?
        if (that.getY2() < this.getY1()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[Region (x1=" + x1 + ", y1=" + y1 + "), (x2=" + x2 + ", y2=" + y2 + ")]";
    }

    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }
}
