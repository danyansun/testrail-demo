package foodtruck.model;

/**
 * @author Michelle
 */
public class Device {
    private int height;
    private int width;

    public Device(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getWidth(){
        return this.width;
    }
}
