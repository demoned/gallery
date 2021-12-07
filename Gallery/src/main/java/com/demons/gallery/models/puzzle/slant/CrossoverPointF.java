package com.demons.gallery.models.puzzle.slant;

import android.graphics.PointF;

class CrossoverPointF extends PointF {
  SlantLine horizontal;
  SlantLine vertical;

  CrossoverPointF() {

  }

  CrossoverPointF(float x, float y) {
    this.x = x;
    this.y = y;
  }

  CrossoverPointF(SlantLine horizontal, SlantLine vertical) {
    this.horizontal = horizontal;
    this.vertical = vertical;
  }

  void update() {
    if (horizontal == null || vertical == null){
      return;
    }
    SlantUtils.intersectionOfLines(this, horizontal, vertical);
  }
}
