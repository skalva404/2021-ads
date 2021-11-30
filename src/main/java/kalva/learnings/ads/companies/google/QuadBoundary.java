package kalva.learnings.ads.companies.google;

public record QuadBoundary(int minX, int minY, int maxX, int maxY) {

    public boolean inRange(int x, int y) {
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }
}
