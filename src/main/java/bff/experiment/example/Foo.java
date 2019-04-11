package bff.experiment.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Foo {

  @Setter private int num1;
  @Setter private int num2;

  public int sumFoo() {
    return num1 + num2;
  }

}
