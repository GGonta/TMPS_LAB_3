// Client class
public class StructuralDesignPatternExample {

  public static void main(String[] args) {
    // Adapter Pattern Example
    LegacyRectangle legacyRectangle = new LegacyRectangleImpl();
    Rectangle rectangle = new RectangleAdapter(legacyRectangle);
    rectangle.display(10, 20, 30, 40);

    // Decorator Pattern Example
    Shape circle = new Circle();
    Shape decoratedCircle = new RedShapeDecorator(new Circle());
    decoratedCircle.draw();

    // Facade Pattern Example
    CarFacade carFacade = new CarFacade();
    carFacade.startCar();
    System.out.println("-----------------------");
    carFacade.stopCar();
  }
}
