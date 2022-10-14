package com.company.gameoflife.worldobjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomWorld extends WorldObject {
  Random gen = new Random();

  public RandomWorld(int x, int y){
    this(x ,y , 10, 10);
  }
  public RandomWorld(int x, int y, int width, int height) {
    super(x, y);
    this.width = width;
    this.height = height;

    this.cells = new ArrayList<>(Collections.nCopies((height) * (width), false));
    for (int i = 0; i < width * height; i++) {
      if (gen.nextBoolean()) {
        this.cells.set(i, true);
      }
    }
  }
}
