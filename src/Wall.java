import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public class Wall implements Structure {
    private static List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    public static void main(String[] args) {
        List<Block> listOfBlocks = new ArrayList();


        List<Block> listOfCompositeBlocks = new ArrayList<>();
        listOfCompositeBlocks.add(new BrickBlock("red", "composite"));
        listOfCompositeBlocks.add(new BrickBlock("blue", "composite"));
        listOfCompositeBlocks.add(new BrickBlock("green", "composite"));

        List<Block> listOfCompositeBlocks2 = new ArrayList<>();
        listOfCompositeBlocks2.add(new BrickBlock("red", "composite"));
        listOfCompositeBlocks2.add(new BrickBlock("blue", "composite"));
        listOfCompositeBlocks2.add(new BrickBlock("green", "composite"));

        listOfBlocks.add(new BrickBlock("red", "clay"));
        listOfBlocks.add(new BrickBlock("red", "clay"));
        listOfBlocks.add(new BrickBlock("blue", "stone"));
        listOfBlocks.add(new BrickBlock("yellow", "clay"));
        listOfBlocks.add(new CompositeBrickBlock("mixed", "composite", listOfCompositeBlocks));
        listOfBlocks.add(new CompositeBrickBlock("mixed", "composite", listOfCompositeBlocks2));

        Wall wall = new Wall(listOfBlocks);

        System.out.println("Find blocks by material \"composite\": " +wall.findBlocksByMaterial("composite") + "\n"
                + "Find block by color \"green\": " + wall.findBlockByColor("green") + "\n"
                + "Number of all blocks in the wall : " + wall.count() + "\n");
        System.out.println("Colors of all blocks");
        wall.makeAnListOfAllBlocks(blocks).stream().forEach(x -> System.out.println(x.getColor()));

    }

    public static List<Block> makeAnListOfAllBlocks(List<Block> blocks){

        List<Block> result = new ArrayList<>();
        for(Block block : blocks){
            if(block instanceof CompositeBrickBlock){
                result.addAll(((CompositeBrickBlock) block).getBlocks());
            }else{
                result.add(block);
            }
        }
        return result;
    }

    @Override
    public Optional findBlockByColor(String color) {

          return makeAnListOfAllBlocks(blocks).stream()
                  .filter(x -> x.getColor().equals(color))
                  .findAny();

    }

    @Override
    public List findBlocksByMaterial(String material) {
        return makeAnListOfAllBlocks(blocks).stream()
                .filter(x -> x.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return makeAnListOfAllBlocks(blocks).size();
    }
}


