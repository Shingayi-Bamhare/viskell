package nl.utwente.group10.ui.components.menu;

import com.google.common.base.Charsets;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import nl.utwente.group10.ui.CustomUIPane;
import nl.utwente.group10.ui.serialize.Exporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A context menu with global actions (i.e. quit).
 */
public class GlobalMenu extends ContextMenu {
    private CustomUIPane pane;

    public GlobalMenu(CustomUIPane pane) {
        super();
        this.pane = pane;

        MenuItem menuNew = new MenuItem("New");
        menuNew.setOnAction(this::onNew);

        MenuItem menuOpen = new MenuItem("Open");
        menuOpen.setOnAction(this::onOpen);

        MenuItem menuSave = new MenuItem("Save");
        menuSave.setOnAction(this::onSave);

        MenuItem menuSaveAs = new MenuItem("Save as");
        menuSaveAs.setOnAction(this::onSaveAs);

        MenuItem menuQuit = new MenuItem("Quit");
        menuQuit.setOnAction(this::onQuit);

        this.getItems().addAll(menuNew, menuOpen, menuSave, menuSaveAs, menuQuit);
    }

    private void onNew(ActionEvent actionEvent) {
        pane.getChildren().clear();
    }

    private void onOpen(ActionEvent actionEvent) {
        Window window = pane.getScene().getWindow();
        File file = new FileChooser().showOpenDialog(window);

        if (file != null) {
            /* Load file... */
        }
    }

    private void onSave(ActionEvent actionEvent) {
    }

    private void onSaveAs(ActionEvent actionEvent) {
        Window window = pane.getScene().getWindow();
        File file = new FileChooser().showSaveDialog(window);

        if (file != null) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(Exporter.export(pane).getBytes(Charsets.UTF_8));
                fos.close();
            } catch (IOException e) {
                // TODO do something sensible here
                e.printStackTrace();
                onSaveAs(actionEvent);
            }
        }
    }

    private void onQuit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
