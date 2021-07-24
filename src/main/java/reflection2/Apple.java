package reflection2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apple {
  Integer size;
  String color;
  private int count = 33;

  public Apple(Integer size, String color) {
    this.size = size;
    this.color = color;
  }

  public String represent1() {
    return toString();
  }

  public String represent2() {
    return toString().toUpperCase();
  }
}
