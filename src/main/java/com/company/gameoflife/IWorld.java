package com.company.gameoflife;

import com.company.gameoflife.worldobjects.WorldObject;

import java.util.List;

public interface IWorld {

  /**
   * Counts how many neighbours are alive
   *
   * @param x horizontal coordinate
   * @param y vertical coordinate
   * @return number of neighbours that are alive from 0 to 8
   */
  int countNeighbours(int x, int y) throws OutOfBounds;

  /**
   * Check if cell (x,y) is alive
   *
   * @param x horizontal coordinate
   * @param y vertical coordinate
   * @return true when the cell is alive, false otherwise
   */
  boolean get(int x, int y) throws OutOfBounds;

  /**
   * Kill particular cell
   *
   * @param x horizontal coordinate
   * @param y vertical coordinate
   */
  void kill(int x, int y) throws OutOfBounds;

  /**
   * Create particular cell
   *
   * @param x horizontal coordinate
   * @param y vertical coordinate
   */
  void create(int x, int y) throws OutOfBounds;

  /**
   * Draws the world with alive and dead cells
   */
  List<Boolean> getCells() throws OutOfBounds;

  /**
   * Simulates the world and updated living/dead cells
   */
  void tick() throws OutOfBounds;

  void simulate(int t);

  /**
   * Add a world Object to the world
   *
   * @param worldObjects - an object to be added
   */
  void add(WorldObject... worldObjects) throws OutOfBounds;
}
