package com.bahmanm.utils.geometry;

import java.util.Arrays;

/**
 * Represents a point in an n-dimensional metric space.<br>
 * NOTE: The code is infected with ugly "for" loops instead of streams to
 * achieve maximum performance.
 *
 * @author Bahman Movaqar [Bahman AT BahmanM.com]
 */
public class Point {

  /** coordinates on each dimension */
  final private double[] coords;

  /** number of dimensions */
  final private int dims;

  /**
   * Creates a Point using the given coordinates.<br>
   * NOTE: It does NOT make a copy of the input parameter.
   *
   * @param coords the given coordinates
   */
  public Point(double[] coords) {
    assert(coords != null && coords.length != 0);
    this.coords = coords;
    dims = coords.length;
  }

  /**
   * Get number of dimensions.
   *
   * @return number of dimensions
   */
  public int getDims() {
    return dims;
  }

  /**
   * Get coordinate value of a given dimension.
   *
   * @param dim the given dimension (first dimension is 0)
   * @return the coordinate value
   */
  public double getCoord(int dim) {
    return coords[dim];
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(coords) + dims;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    else if (obj == null || obj.getClass() != Point.class)
      return false;
    else {
      Point other = (Point) obj;
      return dims == other.dims && Arrays.equals(coords, other.coords);
    }
  }

  @Override
  public Point clone() throws CloneNotSupportedException {
    return (Point) super.clone();
  }

  @Override
  public String toString() {
    return "Point" + Arrays.toString(coords);
  }

}
