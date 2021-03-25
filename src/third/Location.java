package third;
/**
 * Этот класс представляет конкретное местоположение на 2D-карте. Координаты являются целочисленными значениями.
 **/
public class Location {
    /** X координата этого места. **/
    public int xCoord;

    /** Y координата этого места. **/
    public int yCoord;


    /** Создает новое местоположение с указанными целочисленными координатами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Создает новое местоположение с координатами (0, 0). **/
    public Location()
    {
        this(0, 0);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location other = (Location) obj;
            if (xCoord == other.xCoord && yCoord == other.yCoord) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){

        return ((xCoord + 1) * 100 + yCoord);
    }
}
