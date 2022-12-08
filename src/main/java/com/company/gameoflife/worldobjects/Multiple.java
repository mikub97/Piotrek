package com.company.gameoflife.worldobjects;

import com.company.gameoflife.OutOfBounds;

import java.util.ArrayList;
import java.util.Collections;

public class Multiple extends WorldObject {
  public Multiple(int x, int y, WorldObject... worldObjects) {
    super(x, y);
    int widthMax = 0;
    int heightMax = 0;

    for (WorldObject worldObject : worldObjects) {
      widthMax = Integer.max(worldObject.x + worldObject.width, widthMax);
      heightMax = Integer.max(worldObject.y + worldObject.height, heightMax);
    }

    this.width = widthMax;
    this.height = heightMax;
    this.cells = new ArrayList<>(Collections.nCopies((height) * (width), false));

    try {
      this.add(worldObjects);
    } catch (OutOfBounds o) {
    }

  }
}
