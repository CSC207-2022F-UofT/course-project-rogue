package gamedata;

public interface EntityInstance_Interface<T> {
    public T getInstance();
    public void store(T instance);
}
