package Comparators;

import java.io.File;
import java.util.Comparator;

/**
 * Created by Даги on 08.08.2017.
 */
public class SortPackage implements Comparator<File> {
    @Override
    public int compare(File o1, File o2) {
        if (o1.isDirectory()&& !o2.isDirectory()){
            return -1;
        }else if (!o1.isDirectory() && o2.isDirectory()){
            return 1;
        }else {
            return 0;
        }
    }
}
