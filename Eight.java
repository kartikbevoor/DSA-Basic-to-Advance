public class Eight {

    // INTERFACE
    // An interface is a contract that specifies what a class must do, 
    // without necessarily specifying how it should do it.
    // A class can implement the interface
    // Any class implementing interface must provide a method specified by interface
    
    public interface Drawable { // here the interface says any class implementing drawable must provide draw.
        void draw();
    }

    public static  class Square implements Drawable {
        @Override 
        public void draw(){
            System.out.println("Drawing Square");
        }
        
    }
    public static void main(String[] args) {
        Drawable drawable = new Square();   // here the reference type is Drawable, but the actual object is Square
        drawable.draw();
    }
}
