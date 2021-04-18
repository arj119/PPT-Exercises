package generalmatrices.pair;

import generalmatrices.operators.RingElement;

public class PairWithOperators extends Pair implements RingElement<PairWithOperators> {

  public PairWithOperators(Integer coordX, Integer coordY) {
    super(coordX, coordY);
  }

  @Override
  public PairWithOperators sum(PairWithOperators other) {
    int newX = this.getCoordX() + other.getCoordX();
    int newY = this.getCoordY() + other.getCoordY();
    return new PairWithOperators(newX, newY);
  }

  @Override
  public PairWithOperators product(PairWithOperators other) {
    int newX = this.getCoordX() * other.getCoordX();
    int newY = this.getCoordY() * other.getCoordY();
    return new PairWithOperators(newX, newY);
  }
}
