import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import java.util.ArrayList;
import info.gridworld.grid.Location;
import java.util.Scanner;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    

    // the game board will have 5 rows and 5 columns
    private final int ROWS = 20;
    private final int COLS = 20;

    // constants for the location of the three cells initially alive
    private final int X1 = 0, Y1 = 2;
    private final int X2 = 1, Y2 = 2;
    private final int X3 = 2, Y3 = 0;
    private final int X4 = 2, Y4 = 1;
    private final int X5 = 2, Y5 = 2;
    private final int X6 = 2, Y6 = 3;
    private final int X7 = 2, Y7 = 4;
    
    //Number of live cells
    private int live;
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    throws InterruptedException
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        world = new ActorWorld(grid);
        

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();

        // create and add rocks (a type of Actor) to the intial locations 
        
        /*for testing
        Rock rock1 = new Rock();
        Location loc1 = new Location(X1, Y1);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(X2, Y2);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(X3, Y3);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(X4, Y4);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(X5, Y5);
        grid.put(loc5, rock5);

        Rock rock6 = new Rock();
        Location loc6 = new Location(X6, Y6);
        grid.put(loc6, rock6);

        Rock rock7 = new Rock();
        Location loc7 = new Location(X7, Y7);
        grid.put(loc7, rock7);*/
        
        //for Game
        Rock r = new Rock();
        for(int i =0; i<100; i++)
        {
            grid.put(world.getRandomEmptyLocation(),r);
            live++;
        }
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    throws InterruptedException
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *   in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */

        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid(); 

        // insert magic here...
        BoundedGrid<Actor> newGrid = new BoundedGrid<Actor>(ROWS, COLS);
        
        live = 0;
        //Goes through grid and adds all cells that will be alive in next generation to newGrid
        for(int count = 0; count < ROWS; count++)
        {
            for(int count2 = 0; count2 < COLS; count2++)  
            {
                Location testLoc = new Location(count, count2);
                Rock alive = new Rock();
                ArrayList<Location> occ = grid.getOccupiedAdjacentLocations(testLoc);
                
                if(occ.size() == 3)
                {
                    newGrid.put(testLoc, alive);
                    
                }
                else if(occ.size() == 2 && grid.get(testLoc) != null)
                {
                    newGrid.put(testLoc, alive);
                    
                }

                //System.out.println(occ);
                // Thread.sleep(100);

            }
        }
        
        ArrayList<Location> occLocs = newGrid.getOccupiedLocations();
        //.setGrid() didn't work so this updates the grid by comparing it to newGrid
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                Location fixLoc = new Location(i, j);
                Rock rock = new Rock();
                
                if( occLocs.contains(fixLoc))
                {
                    grid.put(fixLoc, rock);
                    live++;
                    //System.out.println("Adding" + fixLoc);
                }
                else
                {
                    grid.remove(fixLoc);
                    //System.out.println("Remove"+ fixLoc);
                }
            }
        }
    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    /**
     * Calls CreateNextGeneration to allow public access to the method for testing
     */
    public void showNextGen()
    throws InterruptedException
    {
        this.createNextGeneration();
    }
    
    /**
     * @return  the number of live cells on the game board
     */
    public int getNumLive()
    throws InterruptedException
    {
        return this.live;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
    */
    public static void main(String[] args)
    throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
        Scanner s = new Scanner(System.in);
        System.out.println("Click Run.\n");
        String cont = "y";
        System.out.println("Starting live cells: " + game.getNumLive());
        while(cont.equals("y"))
        {
            System.out.print("Input how many generations you would like to see: ");
            int gens = s.nextInt();
            System.out.println("Generations:\t\tLive Cells:");
            for(int count = 1; count <= gens; count++)
            {
                Thread.sleep(200);
                game.showNextGen();
                System.out.println(count+"\t\t\t\t"+game.getNumLive());
            }
            System.out.print("Would you like to continue? (y/n): ");
            cont = s.next();
        }
        System.out.print("Thanks for watching!");
        
    }
}                