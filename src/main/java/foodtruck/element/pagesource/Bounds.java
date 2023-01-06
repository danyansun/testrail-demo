package foodtruck.element.pagesource;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import java.util.Map;
import java.util.Optional;

public class Bounds extends Rectangle {

    public Bounds(Rectangle rectangle) {
        super(rectangle.x, rectangle.y, rectangle.height, rectangle.width);
    }

    public Bounds(Point point, Dimension dimension) {
        super(point, dimension);
    }

    public Bounds(int x, int y, int width, int height) {
        super(x, y, height, width);
    }

    public Bounds(Map map) {
        super(
            ((Long) Optional.ofNullable(map.get("x")).orElse(map.get("left"))).intValue(),
            ((Long) Optional.ofNullable(map.get("y")).orElse(map.get("top"))).intValue(),
            ((Long) map.get("height")).intValue(),
            ((Long) map.get("width")).intValue()
        );
    }

    public Point getCenter() {
        return new Point(x + width / 2,
            y + height / 2);
    }

    public Point getRelativePoint(double xRatio, double yRatio) {
        return new Point((int) (x + width * xRatio),
            (int) (y + height * yRatio));
    }

    public Bounds resizeBy(int pixelRatio) {
        return new Bounds(
            x / pixelRatio,
            y / pixelRatio,
            width / pixelRatio,
            height / pixelRatio
        );
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Bounds) {
            Bounds bounds = (Bounds) object;
            return x == bounds.x
                && y == bounds.y
                && width == bounds.width
                && height == bounds.height;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d, %d, %d]", x, y, width, height);
    }

    public int right() {
        return x + width;
    }

    public int bottom() {
        return y + height;
    }

    public boolean contains(Rectangle bounds) {
        return x <= bounds.x
            && y <= bounds.y
            && right() >= (bounds.x + bounds.width)
            && bottom() >= (bounds.y + bounds.height);
    }

    public boolean contains(Point point) {
        return x <= point.x && point.x <= right()
            && y <= point.y && point.y <= bottom();
    }

    public void resizeWithin(Bounds bounds) {
        x = Math.max(x, bounds.x);
        y = Math.max(y, bounds.y);
        height = Math.min(y + height, bounds.y + bounds.height) - y;
        width = Math.min(x + width, bounds.x + bounds.width) - x;
    }

    public int area() {
        return width * height;
    }
}
