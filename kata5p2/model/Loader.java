package kata5p2.model;

public interface Loader<T> {
    Iterable<T> items();
}
