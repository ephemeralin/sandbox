
package ex;

/**
 * The type A.
 */
class A { }

/**
 * The type B.
 */
class B extends A { }

/**
 * The type Ex.
 */
public class Ex {

    /**
     * Foo.
     *
     * @param a the a
     */
    static void foo(A a) {
        System.out.println("foo A");
    }

    /**
     * Foo.
     *
     * @param b the b
     */
    static void foo(B b) {
        System.out.println("foo B");
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        A a = new B();
        foo(a);
        foo(null);
    }
}
