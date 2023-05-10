# În exemplul de cod pe care l-am scris sunt utilizate trei Structural Design Patterns diferite.
## Adapter Pattern (Modelul Adaptorului): 
Modelul Adaptorului permite obiectelor cu interfețe incompatibile să lucreze împreună prin furnizarea unei interfețe comune. În exemplul tău, clasa RectangleAdapter acționează ca un adaptor care permite interfeței Rectangle să funcționeze cu interfața moștenită LegacyRectangle. Aceasta traduce metoda display din interfața Rectangle în metoda display a interfeței LegacyRectangle.

```
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
```
## Decorator Pattern (Modelul Decoratorului):
Modelul Decoratorului permite adăugarea de funcționalități suplimentare la un obiect existent fără a afecta alte instanțe ale aceleiași clase. În exemplul tău, clasa abstractă ShapeDecorator este un decorator care implementează interfața Shape și conține o referință la un obiect Shape de bază. Clasa RedShapeDecorator este un decorator concret care adaugă culoarea roșie la forma de bază prin intermediul metodei draw.

```
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
```
## Facade Pattern (Modelul Fațadei):
Modelul Fațadei oferă o interfață simplificată pentru a accesa un sistem complex de clase. Aceasta ascunde detaliile complexe ale sistemului și oferă o interfață mai ușor de utilizat. În exemplul tău, clasa CarFacade este o fațadă care abstractizează sistemul complex al unui automobil. Aceasta oferă metode simple, cum ar fi startCar și stopCar, care se ocupă de pornirea și oprirea motorului, injectarea de combustibil și aprinderea motorului, fără a dezvălui detaliile interne ale acestor acțiuni.
```
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
```