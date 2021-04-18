package generalmatrices.matrix;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

// TODO: populate as part of Question 1 and Question 3
  
public class Matrix<T> {
  private final List<List<T>> matrix;
  private final int order;

  public Matrix(List<T> elements) throws IllegalArgumentException {
    if (elements.isEmpty()) throw new IllegalArgumentException();
    order = (int) Math.sqrt(elements.size());
    matrix = new ArrayList<>();
    for (int i = 0; i < order; i++) {
      List<T> row = new ArrayList<>();
      for (int j = 0; j < order; j++) {
        row.add(elements.get(i * order + j));
      }
      matrix.add(row);
    }
  }
  
  public T get (int row, int col){
    return matrix.get(row).get(col);
  }

  public int getOrder(){
    return matrix.size();
  }

  public Matrix<T> sum(Matrix<T> other, BinaryOperator<T> elementSum) {
    List<T> result = new ArrayList<>();
    for (int i = 0; i < order; i++) {
      for (int j = 0; j < order; j++)
        result.add(elementSum.apply(this.get(i, j), other.get(i, j)));
    }
    return new Matrix<>(result);
  }

  // this = [[1 2] [3 4]] other = [[1 1] [1 1]]
  // result = [3 3 7 7]
  // newMatrix = [[3 3] [7 7]]

  public Matrix<T> product(Matrix<T> other, BinaryOperator<T> elementSum, BinaryOperator<T> elementProd) {
    List<T> result = new ArrayList<>();
    for(int i = 0; i < order; i++) {
      for(int j = 0; j < order; j++) {
        T sum = null;
        for (int k = 0; k < order; k++) {
          T prod = elementProd.apply(this.get(i, k), other.get(k, j));
          sum = (sum == null) ? prod : elementSum.apply(sum, prod);
        }
        result.add(sum);
      }
    }
    return new Matrix<>(result);
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("[");
    for (int i = 0; i < order; i++){
      s.append("[");
      for (int j = 0; j < order; j++){
        s.append(matrix.get(i).get(j));
        if (j != order - 1) s.append(" ");
      }
      s.append("]");
    }
    s.append ("]");
    return s.toString();
  }
  
  private String toStringAlt() {
    return "["
         + matrix.stream().map(row -> {
           return "[" + row.stream().map(Object::toString).collect(Collectors.joining(" ")) + "]";
         }).collect(Collectors.joining(" "))
         + "]";
  }


}
