import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Даги on 29.11.2017.
 */
public class Controller implements Initializable{
    @FXML
    public TreeView trvExp;
    TreeItem<String> rootItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootItem = new TreeItem<>("Computer");
        rootItem.getChildren().addAll(Item.getRootDirectories());
        trvExp.setRoot(rootItem);
    }
}
