package Comparators;

import java.io.File;
import java.util.Comparator;

/**
 * Created by Даги on 08.08.2017.
 */
public class SortName implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        return o1.compareTo(o2);
    }
}
