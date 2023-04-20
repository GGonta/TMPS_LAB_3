// Adapter Pattern
// Adaptee interface
interface LegacyRectangle {
  void display(int x1, int y1, int x2, int y2);
}

// Adaptee implementation
class LegacyRectangleImpl implements LegacyRectangle {
  @Override
  public void display(int x1, int y1, int x2, int y2) {
    System.out.println("Legacy Rectangle: (" + x1 + ", " + y1 + ") - (" + x2 + ", " + y2 + ")");
  }
}

// Target interface
interface Rectangle {
  void display(int x, int y, int width, int height);
}

// Adapter implementation
class RectangleAdapter implements Rectangle {
  private LegacyRectangle legacyRectangle;

  public RectangleAdapter(LegacyRectangle legacyRectangle) {
    this.legacyRectangle = legacyRectangle;
  }

  @Override
  public void display(int x, int y, int width, int height) {
    int x1 = x;
    int y1 = y;
    int x2 = x + width;
    int y2 = y + height;
    legacyRectangle.display(x1, y1, x2, y2);
  }
}

// Decorator Pattern
// Component interface
interface Shape {
  void draw();
}

// Concrete Component implementation
class Circle implements Shape {
  @Override
  public void draw() {
    System.out.println("Drawing Circle");
  }
}

// Decorator abstract class
abstract class ShapeDecorator implements Shape {
  protected Shape shape;

  public ShapeDecorator(Shape shape) {
    this.shape = shape;
  }

  @Override
  public void draw() {
    shape.draw();
  }
}

// Concrete Decorator implementation
class RedShapeDecorator extends ShapeDecorator {
  public RedShapeDecorator(Shape shape) {
    super(shape);
  }

  @Override
  public void draw() {
    shape.draw();
    System.out.println("Applying Red color");
  }
}

// Facade Pattern
// Subsystem classes
class Engine {
  public void start() {
    System.out.println("Engine started");
  }

  public void stop() {
    System.out.println("Engine stopped");
  }
}

class FuelInjector {
  public void injectFuel() {
    System.out.println("Fuel injected");
  }

  public void stopFuelInjection() {
    System.out.println("Fuel injection stopped");
  }
}

class Ignition {
  public void ignite() {
    System.out.println("Ignition started");
  }

  public void stopIgnition() {
    System.out.println("Ignition stopped");
  }
}

// Facade class
class CarFacade {
  private Engine engine;
  private FuelInjector fuelInjector;
  private Ignition ignition;

  public CarFacade() {
    engine = new Engine();
    fuelInjector = new FuelInjector();
    ignition = new Ignition();
  }

  public void startCar() {
    System.out.println("Starting car...");
    engine.start();
    fuelInjector.injectFuel();
    ignition.ignite();
    System.out.println("Car started");
  }

  public void stopCar() {
    System.out.println("Stopping car...");
    engine.stop();
    fuelInjector.stopFuelInjection();
    ignition.stopIgnition();
    System.out.println("Car stopped");
  }
}

