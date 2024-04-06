
public class Question2 {
    public static void main(String[] args) {
        Rectangle obj1 = new Rectangle(4,40);
        Rectangle obj2 = new Rectangle(3.5, 35.9);

        System.out.println("Width and height of obj1: "+obj1.width+" "+obj1.height);
        System.out.println("Width and height of obj2: "+obj2.width+" "+obj2.height);
        System.out.println("Area and perimeter of obj1: "+obj1.getArea()+" "+obj1.getPerimeter());
        System.out.println("Area and perimeter of obj2: "+obj2.getArea()+" "+obj2.getPerimeter());
    }
}
class Rectangle {
    double width = 1;
    double height = 1;

    Rectangle(){
    }
    Rectangle(double newWidth, double newHeight){
        width = newWidth;
        height = newHeight;
    }
    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return 2*(width + height);
    }
}