package fruits;

@Ready (owner = "Dima", val = 50)
public class Apple implements Nameable {
    @Override
    public String name() {
        return "I'm Apple";
    }
}
