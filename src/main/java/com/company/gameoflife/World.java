package com.company.gameoflife;

import com.company.gameoflife.worldobjects.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class World extends WorldObject implements IWorld {

  public World() {
    this(10, 10);
  }

  public World(int width, int height) {
    super(-1, -1);
    this.width = width + 2;
    this.height = height + 2;

    this.cells = new ArrayList<>(Collections.nCopies(this.width * this.height, false));

  }


  @Override
  public int countNeighbours(int x, int y) throws OutOfBounds {
    int count = 0;
    for (int i = 1; i >= -1; i--) {
      for (int j = 1; j >= -1; j--) {
        if (i == 0 && j == 0) continue;
        if (get(x + i, y + j)) count++;
      }
    }
    return count;
  }


  @Override
  public void kill(int x, int y) throws OutOfBounds {
    if (editable(x, y)) {
      int id = getId(x, y);
      cells.set(id, false);
    }
  }

  @Override
  public void create(int x, int y) throws OutOfBounds {
    if (editable(x, y)) {
      int id = getId(x, y);
      cells.set(id, true);
    }
  }

  @Override
  public String toString(){
    StringBuilder map = new StringBuilder();

    for (int j = 1; j <= height - 2; j++) {
      for (int i = 1; i <= width - 2; i++) {
        if (this.get(i, j)) {
          map.append("#");
        } else {
          map.append("_");
        }
      }
      map.append("\n");
    }
    return String.valueOf(map);
  }

  @Override
  public void tick() throws OutOfBounds {

    List<Integer> lives = new LinkedList<>();
    List<Integer> dies = new LinkedList<>();
    for (int j = 1; j <= height - 2; j++) {
      for (int i = 1; i <= width - 2; i++) {
        if (countNeighbours(i, j) < 2) {
          dies.add(getId(i, j));
        } else if (countNeighbours(i, j) == 3) {
          lives.add(getId(i, j));
        } else if (countNeighbours(i, j) > 3) {
          dies.add(getId(i, j));
        }
      }
    }

    for (int id : lives) {
      create(getX(id), getY(id));
    }

    for (int id : dies) {
      kill(getX(id), getY(id));
    }
  }

  @Override
  public void simulate(int t) {
    for (int i = 1; i <= t; i++) {
      try {
        System.out.print("\033[H\033[2J");
        System.out.println(this);
        tick();
        Thread.sleep(100);
      } catch (Exception ignored) { // OutOfBounds is included in Exception
      }
    }
  }

  @Override
  public List<Boolean> getCells(){
    return this.cells;
  }

  public void add(WorldObject... worldObjects) throws OutOfBounds {
    super.add(1, 1, worldObjects);
  }

  public static void main(String[] args) throws OutOfBounds {
    IWorld world = new World(10, 10);

    WorldObject s1 = new RandomWorld(0, 0);
    world.add(s1);

    world.simulate(100);
  }
}
