package solid.srp.solution.square;

public class Square {

    private int side = 5;

    public int calculateArea() {
        return side * side; // side² - side ^ 2;
    }

    public int calculatePerimeter() {
        return side * 4;
    }
}
