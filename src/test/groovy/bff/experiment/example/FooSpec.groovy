package bff.experiment.example

import spock.lang.Specification

class FooSpec extends Specification {

  def "add 2 numbers for the class"() {
    given:
    Foo foo = new Foo()
    foo.setNum1(1)
    foo.setNum2(2)

    when:
    def sum = foo.sumFoo()

    then:
    sum == 3
  }

  def "add another 2 numbers for the class"() {
    given:
    Foo foo = new Foo(1,2)

    when:
    def sum = foo.sumFoo()

    then:
    sum == 3
  }

}