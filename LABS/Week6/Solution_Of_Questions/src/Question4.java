public class Question4 {
    public static void main(String[] args){
        Fan obj1 = new Fan();
        Fan obj2 = new Fan();

        obj1.setSpeed(obj1.FAST);
        obj1.setRadius(10);
        obj1.setColor("yellow");
        obj1.setOn(true);

        obj2.setSpeed(obj2.MEDIUM);
        obj2.setRadius(5);
        obj2.setColor("blue");
        obj2.setOn(false);

        System.out.println(obj1.toString(obj1.getSpeed(), obj1.getRadius(), obj1.getColor(), obj1.getOn() ));
        System.out.println(obj2.toString(obj2.getSpeed(), obj2.getRadius(), obj2.getColor(), obj2.getOn() ));

    }
}
class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    String color = "blue";

    Fan(){

    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public boolean getOn(){
        return on;
    }
    public void setOn(boolean newOn){
        on = newOn;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String newColor){
        color = newColor;
    }
    public String toString(int speed, double radius, String color, boolean on){
        String result;
        if(on){
            result = "Speed is " + speed + " Color is "+ color + " Radius is " + radius;
            return result;
        }
        else{
            result = "fan is off, " +"Color is " + color + " Radius is " + radius;
            return result;
        }
    }
}
