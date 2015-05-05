package nl.utwente.group10.ui.components.blocks;

import java.util.List;

import nl.utwente.group10.haskell.type.Type;
import nl.utwente.group10.ui.components.anchors.InputAnchor;

public interface InputBlock {
    /**
     * @param input
     *            The argument of which the type is desired.
     * @return The type that the specified input argument accepts.
     */
    public Type getInputSignature(InputAnchor input);

    public Type getInputSignature(int index);

    /**
     * @param input
     *            The argument of which the type is desired.
     * @return The current type given to the specified input argument.
     */
    public Type getInputType(InputAnchor input);

    public Type getInputType(int index);

    /**
     * @return The inputs of the block.
     */
    public List<InputAnchor> getInputs();

    /**
     * @return The index the specified anchor has (in getInputs())
     */
    public int getInputIndex(InputAnchor anchor);

    /**
     * @return True if inputIsConnected() for all inputs.
     */
    public boolean inputsAreConnected();

    /**
     * @return True if the specified input is fully connected, ie has a
     *         connection to another output anchor.
     */
    public boolean inputIsConnected(int index);
}
