package ca.bcit.comp2526.a2b;

/**
 * World.java
 * World class that construct the world of cells.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class World {
    
    private static final int MAX_PERCENTAGE = 100;
    private static final int PERCENTAGE_HERBIVORE = 80;
    private static final int PERCENTAGE_PLANT = 50;
    private static final int PERCENTAGE_CARNIBORE = 40;
    private static final int PERCENTAGE_OMNIBORE = 32;
    private final Cell[][] cell;
    private final int worldSizeRow;
    private final int worldSizeColumn;
    private int random;

    /**
     * Constructor that creates the world.
     * @param worldSize width of the world
     * @param worldSize2 height of the world
     */
    public World(final int worldSize, final int worldSize2) {
        this.worldSizeRow = worldSize2;
        this.worldSizeColumn = worldSize;
        cell = new Cell[worldSizeColumn][worldSizeRow];
    }

    /**
     * initializes world objects.
     */
    public void init() {

        for (int i = 0; i < worldSizeColumn; i++) {
            for (int j = 0; j < worldSizeRow; j++) {
                random = RandomGenerator.nextNumber(MAX_PERCENTAGE);
                cell[i][j] = new Cell(this, i, j);
                if (random > PERCENTAGE_HERBIVORE) {
                    cell[i][j].setLifeForm(LifeForm.HERBIVORE);
                } else if (random > PERCENTAGE_PLANT) {
                    cell[i][j].setLifeForm(LifeForm.PLANT);
                } else if (random > PERCENTAGE_CARNIBORE) {
                    cell[i][j].setLifeForm(LifeForm.CARNIVORE);
                } else if (random > PERCENTAGE_OMNIBORE) {
                    cell[i][j].setLifeForm(LifeForm.OMNIVORE);
                } else {
                    cell[i][j].setLifeForm(LifeForm.NATURE);
                }
                cell[i][j].init();
            }
        }
    }

    /**
     * gets row number.
     * @return row number
     */
    public int getRowCount() {
        return worldSizeRow;
    }
    
    /**
     * gets column number.
     * @return column number
     */
    public int getColumnCount() {
        return worldSizeColumn;
    }

    /**
     * gets one specific Cell.
     * @param rowInput used for identifying specific Cell element in an array
     * @param colInput used for identifying specific Cell element in an array
     * @return one element of the cell array
     */
    public Cell getCellAt(final int colInput, final int rowInput) {
        return cell[colInput][rowInput];
    }
    
    /**
     * sets creatures to adults, removes dead animals,
     * makes plants seed, makes animals reproduce 
     * (omnivore, carnivore, herbivore in order),
     * and makes animals act.
     */
    public void takeTurn() {
        this.worldSetBaby();
        this.worldDieCreature();
        this.worldReproduceCreature();
        this.worldActCreature();
        for (int i = 0; i < worldSizeColumn; i++) {
            for (int j = 0; j < worldSizeRow; j++) {
                cell[i][j].init();
            }
        }
    }
    
    private void worldSetBaby() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (cell[i][j].getLifeForm() != LifeForm.NATURE) {
                    cell[i][j].getCreature().setBaby(false);
                }
            }
        }
    }
    
    private void worldDieCreature() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if ((cell[i][j].getLifeForm() == LifeForm.HERBIVORE
                        || cell[i][j].getLifeForm() == LifeForm.OMNIVORE
                        || cell[i][j].getLifeForm() == LifeForm.CARNIVORE)
                        && !cell[i][j].getCreature().getBaby()) {
                    ((Animal) cell[i][j].getCreature()).die();
                }
            }
        }
    }
    
    private void worldReproduceCreature() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if (cell[i][j].getLifeForm() == LifeForm.PLANT
                        && !cell[i][j].getCreature().getBaby()) {
                    cell[i][j].getCreature().reproduce();
                }
            }
        }
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if ((cell[i][j].getLifeForm() == LifeForm.HERBIVORE
                        || cell[i][j].getLifeForm() == LifeForm.OMNIVORE
                        || cell[i][j].getLifeForm() == LifeForm.CARNIVORE)
                        && !cell[i][j].getCreature().getBaby()) {
                    cell[i][j].getCreature().reproduce();
                }
            }
        }
    }
    
    private void worldActCreature() {
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[0].length; j++) {
                if ((cell[i][j].getLifeForm() == LifeForm.HERBIVORE
                        || cell[i][j].getLifeForm() == LifeForm.OMNIVORE
                        || cell[i][j].getLifeForm() == LifeForm.CARNIVORE)
                        && !cell[i][j].getCreature().getBaby()) {
                    ((Animal) cell[i][j].getCreature()).act();
                }
            }
        }
    }
    
}
