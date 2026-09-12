public class Eight {

    // INTERFACE
    // An interface is a contract that specifies what a class must do, 
    // without necessarily specifying how it should do it.
    // A class can implement the interface
    // Any class implementing interface must provide a method specified by interface
    
    public interface Drawable { // here the interface says any class implementing drawable must provide draw.
        // Variables declared in side a interface are public, static and final.
        // note: interface methods are traditionally abstract methods which they has be overriden by the implementing class.
        void draw();
    }

    public static  class Square implements Drawable {
        @Override 
        public void draw(){
            System.out.println("Drawing Square");
        }
        
    }

    public interface Animal {
        void sound();
    }

    public static class Dog implements Animal {
        @Override 
        public void sound(){
            System.out.println("Bow Bow");
        }
    }

    // Multiple Inheritance Using Interfaces

    interface Camera {
        void takePhoto();
    }

    interface MusicPlayer {
        void playMusic();
    }

    static class Smartphone implements Camera, MusicPlayer {

        @Override
        public void takePhoto() {
            System.out.println("Taking photo");
        }

        @Override
        public void playMusic() {
            System.out.println("Playing music");
        }
    }

    // Interface Extending Another Interface
    public static void main(String[] args) {
        Drawable drawable = new Square();   // here the reference type is Drawable, but the actual object is Square
        drawable.draw();

        // Drawable d = new Drawable // This is invalid: Because an interface generally defines a contract rather than a concrete object implementation.

        Animal animal = new Dog(); // Animal reference type, animal reference and new actual object 
        // The reference says: I can access things defined by Animal.
        // The object says: At runtime, I am actually a Dog.
        animal.sound(); // calls Dog.sound(), this is runtime polymorphism.
    }
}
