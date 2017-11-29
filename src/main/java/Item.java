import Comparators.SortName;
import Comparators.SortPackage;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Даги on 19.07.2017.
 */
public class Item extends TreeItem<String> {
    private ObservableList<TreeItem<String>> listItem = Item.this.getChildren();
    private File file;

    Item(File file) {
        this.file = file;
        this.setValue(file.getName());
        if (file.isDirectory()) {
            listItem.add(null);
            EventHandler handler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    if (listItem.get(0) == null) {
                        listItem.remove(0);
                        Item.this.addItems(file);
                    }
                }
            };
            this.addEventHandler(TreeItem.branchExpandedEvent(), handler);
        }
    }

    private void addItems(File file) {
        File[] arrayFiles = file.listFiles();
        if (arrayFiles != null && arrayFiles.length > 0) {
            List<File> files = Arrays.asList(arrayFiles);
            files.sort(new SortPackage().thenComparing(new SortName()));
            for (File file1 : files) {
                Item item = new Item(file1);
                listItem.add(item);
            }
        } else {
            listItem.add(null);
        }
    }

    static List<Item> getRootDirectories() {
        List<Item> listItem = new ArrayList<>();
        File[] rootList = File.listRoots();
        for (File file : rootList) {
            Item item = new Item(file);
            item.setValue(file.getAbsolutePath());
            listItem.add(item);
        }
        return listItem;
    }

    String getFileExtension() {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "dir";
        }
    }
}
