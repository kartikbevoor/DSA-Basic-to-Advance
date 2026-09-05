public class Seven {

    // Class declaration 
    // Non-static inner class
    // A non-static inner-class object is associated with an object of the outer class.
    // In other words, a Person needs a Seven object.
    public class Person {
        String name;
        int age;

        public void greet(){
            System.out.println("Hello " + name);
        }
        
    }

    public static class Box{    // Static class
        int w;
        int h;
        int l;

        // Constructors
        Box(){      // default constructor
            h = 1;
            w = 1;
            l = 1;
        }

        Box(int h, int w, int l){   // parametrised constructor
            this.l = l;
            this.w = w;
            this.h = h;
        }

        int area(){
            return l*w;
        }

        int volume(){
            return l*w*h;
        }
    }
    public static void main(String[] args) {
        Seven s = new Seven();
        Person p = s.new Person();  // a non-static inner class which needs an instance of its outer class
        p.name = "Fuck U";
        p.age = 23;

        p.greet();
    }
}
