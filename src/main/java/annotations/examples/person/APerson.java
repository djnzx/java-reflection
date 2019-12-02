package annotations.examples.person;

@AnnClass(author="Alex", birthday="01.01.1991")
public class APerson {
    @AnnField(key=true)
    private final int id;
    @AnnField
    private final String name;

    public APerson(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public void print1() {
        System.out.printf("PRINT1: %s\n", toString());
    }

    @AnnMethod (smart = true)
    public void print2() {
        System.out.printf("PRINT2: %s\n", toString());
    }

    @Override
    public String toString() {
        return "id:"+id+", name:"+name;
    }
}
