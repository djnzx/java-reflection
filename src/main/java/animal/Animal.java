package animal;

@AnimalClassExtra(behavior="strong")
public class Animal {
    @AnimalField
    private final String name;

    @AnimalMethod
    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("My name: %s", this.name);
    }
}
