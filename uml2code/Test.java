package uml2code;

class Test {
    public static void main (String[] args) {
        System.out.println("Hej");
        Tomat t = new Tomat(5);
        System.out.println(t.x);
    }
}

class Tomat {
    int x;
    public Tomat(int x){
        this.x = x;
    }
}