import java.util.List;

public class CompositeBrickBlock  implements CompositeBlock{

    private String color;
    private String material;
    private List blocks;


    public CompositeBrickBlock(String color, String material, List blocks) {
        this.color = color;
        this.material = material;
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return null;
    }

    @Override
    public List getBlocks() {
        return blocks;
    }
}
