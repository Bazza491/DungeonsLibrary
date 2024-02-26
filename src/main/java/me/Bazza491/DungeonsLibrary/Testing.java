package me.Bazza491.DungeonsLibrary;

public class Testing {
    public static void main(String args[]) {
        B b = new B(10);
    }
}

class A {
    protected int a;
    public A(int a) {
        this.a = a;
        System.out.println(a);
    }
}
class B extends A {
    public B(int b) {
        super(b);
        System.out.println(a);
    }
}
