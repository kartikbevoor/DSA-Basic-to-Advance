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

        Box(Box b){                // copy constructor
            this.h = b.h;
            this.l = b.l;
            this.w = b.w;
        }

        int area(){
            return l*w;
        }

        int area(int l, int b, int h){  // Method overloading
            int area = 0;

            area = 2 * (l * b + l * h + b * h);

            return area;
        }

        int volume(){
            return l*w*h;
        }
    }

    public static class Box2 extends Box {
        
        
    }
    public static void main(String[] args) {
        Seven s = new Seven();
        Person p = s.new Person();  // a non-static inner class which needs an instance of its outer class
        p.name = "Fuck U";
        p.age = 23;

        p.greet();

        Box b = new Box();  // here default constructor is used
        System.out.println(b.area());

        Box b1 = new Box(10, 10, 10);   // here parameterised constructor is used
        System.out.println(b1.volume());

        Box b2 = new Box(b1);   // here copy constructor is used
        System.out.println(b2.area());
        System.out.println(b2.area(b2.l, b2.w, b2.h));
    }
}
