public class Rover {
    private Area area;
    private int x;
    private int y;
    private String direction;

    public void land(Area area, int x, int y, String direction)  {
        if (x > area.getX()){
            throw new IllegalArgumentException("x=" + x + "is out of area width" + area.getX());
        }
        if (y > area.getY() ){
            throw new IllegalArgumentException("y=" + y + "is out of area width" + area.getY());
        }
        this.area = area;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getPosition() {
        return ""+ x + y + direction;
    }

    public void move() {
        if (direction.equals("E") ) {
            x +=1;
        } else if (direction.equals("W") ) {
            x -= 1;
        } else if (direction.equals("N") ){
            y +=1;
        } else {
            y -= 1;
        }

    }

    public void turnleft() {
        if (direction.equals("E") ) {
            direction = "N";
        } else if (direction.equals("W") ) {
            direction = "S";
        } else if (direction.equals("N") ){
            direction = "W";
        } else {
            direction = "E";
        }
        return;
    }

    public void turnright() {
        if (direction .equals("E") ) {
            direction = "S";
        } else if (direction.equals("W") ) {
            direction = "N";
        } else if (direction.equals("N") ){
            direction = "E";
        } else {
            direction = "W";
        }
        return;
    }
}
