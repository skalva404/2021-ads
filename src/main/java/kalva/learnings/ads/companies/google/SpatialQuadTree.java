package kalva.learnings.ads.companies.google;

import java.util.LinkedList;
import java.util.List;

public class SpatialQuadTree {

    private final static int CAPACITY = 4;

    int level;
    private SpatialQuadTree nw;
    private SpatialQuadTree ne;
    private SpatialQuadTree sw;
    private SpatialQuadTree se;
    private QuadBoundary boundary;
    private List<QuadNode> nodes = new LinkedList<>();

    public SpatialQuadTree(int level, QuadBoundary boundary) {
        this.level = level;
        this.boundary = boundary;
    }

    static void dfs(SpatialQuadTree tree) {
        if (tree == null)
            return;

        System.out.printf("\nLevel = %d [X1=%d Y1=%d] \t[X2=%d Y2=%d] ",
                tree.level, tree.boundary.minX(), tree.boundary.minY(),
                tree.boundary.maxX(), tree.boundary.maxY());

        for (QuadNode node : tree.nodes) {
            System.out.printf(" \n\t  x=%d y=%d", node.x(), node.y());
        }
        if (tree.nodes.size() == 0) {
            System.out.printf(" \n\t  Leaf Node.");
        }
        dfs(tree.ne);
        dfs(tree.ne);
        dfs(tree.sw);
        dfs(tree.se);
    }

    public void insert(int x, int y, int value) {

        if (!boundary.inRange(x, y)) {
            return;
        }
        if (nodes.size() < CAPACITY) {
            nodes.add(new QuadNode(value, x, y));
            return;
        }
        if (null == nw) {
            split();
        }
        if (nw.boundary.inRange(x, y)) {
            nw.insert(value, x, y);
        } else if (ne.boundary.inRange(x, y)) {
            ne.insert(value, x, y);
        } else if (sw.boundary.inRange(x, y)) {
            sw.insert(value, x, y);
        } else if (se.boundary.inRange(x, y)) {
            se.insert(value, x, y);
        } else {
            System.out.printf("ERROR : Unhandled partition %d %d", x, y);
        }
    }

    private void split() {

        int xOffset = boundary.minX() + (boundary.maxX() - boundary.minX()) / 2;
        int yOffset = boundary.minY() + (boundary.maxY() - boundary.minY()) / 2;

        nw = new SpatialQuadTree(level + 1,
                new QuadBoundary(boundary.minX(), yOffset, xOffset, boundary.maxY()));
        ne = new SpatialQuadTree(level + 1,
                new QuadBoundary(xOffset, yOffset, boundary.maxX(), boundary.maxY()));
        sw = new SpatialQuadTree(level + 1,
                new QuadBoundary(boundary.minX(), boundary.minY(), xOffset, yOffset));
        se = new SpatialQuadTree(level + 1,
                new QuadBoundary(xOffset, boundary.minY(), boundary.maxX(), yOffset));
    }

    public static void main(String[] args) {

        SpatialQuadTree anySpace = new SpatialQuadTree(1,
                new QuadBoundary(0, 0, 1000, 1000));
        anySpace.insert(100, 100, 1);
        anySpace.insert(500, 500, 1);
        anySpace.insert(600, 600, 1);
        anySpace.insert(700, 600, 1);
        anySpace.insert(800, 600, 1);
        anySpace.insert(900, 600, 1);
        anySpace.insert(510, 610, 1);
        anySpace.insert(520, 620, 1);
        anySpace.insert(530, 630, 1);
        anySpace.insert(540, 640, 1);
        anySpace.insert(550, 650, 1);
        anySpace.insert(555, 655, 1);
        anySpace.insert(560, 660, 1);
        //Traveling the graph
        anySpace.dfs(anySpace);
    }
}
