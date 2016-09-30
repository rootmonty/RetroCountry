package badebaba.retrocountry;

import java.util.Comparator;

/**
 * Created by badebaba on 9/30/2016.
 */

public class AreaComparator implements Comparator<Model> {
    @Override
    public int compare(Model o1, Model o2) {
        if (o1.getArea() == o2.getArea())
            return 0;
        else if (o1.getArea() > o2.getArea())
            return 1;
        else
            return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
