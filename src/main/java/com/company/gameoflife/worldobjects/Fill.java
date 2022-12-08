package com.company.gameoflife.worldobjects;

import java.util.ArrayList;
import java.util.Collections;

public class Fill extends WorldObject {

    public Fill(int x, int y){
        this(x ,y , 10, 10);
    }
    public Fill(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;

        this.cells = new ArrayList<>(Collections.nCopies((height) * (width), true));
    }
}
