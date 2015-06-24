package nl.utwente.group10.ui.components.blocks;

import nl.utwente.group10.haskell.type.Type;
import nl.utwente.group10.ui.components.ComponentLoader;
import nl.utwente.group10.ui.components.anchors.InputAnchor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class InputArgument extends Pane implements ComponentLoader{
    
    @FXML Label inputLabel;
    
    private StringProperty inputText;
    
    private InputAnchor inputAnchor;
    
    public InputArgument(Block block, Type signature) {
        inputText = new SimpleStringProperty(signature.toHaskellType());
        this.loadFXML("InputArgument");
        
        inputAnchor = new InputAnchor(block, signature); //TODO constructor of InputAnchor should be simpler.
        inputAnchor.layoutXProperty().bind(inputLabel.widthProperty().divide(2));

        inputLabel.layoutYProperty().bind(this.heightProperty().divide(2).subtract(inputLabel.heightProperty().divide(2)));
        
        this.setPrefHeight(ArgumentSpace.HEIGHT);
        this.getChildren().add(inputAnchor);
    }
    
    public InputAnchor getInputAnchor() {
        return inputAnchor;
    }
    
    public String getInputText() {
        return inputText.get();
    }
    
    public void setInputText(String text) {
        inputText.set(text);
    }
    
    public StringProperty inputTextProperty() {
        return inputText;
    }
}
