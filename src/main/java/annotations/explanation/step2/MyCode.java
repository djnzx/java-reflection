package annotations.explanation.step2;

import annotations.explanation.step1.*;

@Neutral
public class MyCode {

  @Good
  protected int x;

  @Better
  private String s;

  @Worse
  public MyCode() {
  }

  @TheBest
  public MyCode(@Neutral int x, String s) {
    this.x = x;
    this.s = s;
  }

  @Bad
  public int getX() {
    return x;
  }

  @TheWorst
  public void setX(@TheWorst int x) {
    this.x = x;
  }
}
