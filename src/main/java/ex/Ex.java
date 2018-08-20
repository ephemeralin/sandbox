
package ex;

class A {}

class B extends A{}

public class Ex {


    static void foo (A a) {
        System.out.println("foo A");
    }

    static void foo (B b) {
        System.out.println("foo B");
    }



    public static void main(String[] args) {
        A a = new B();
        foo(a);
        foo(null);
    }
}
