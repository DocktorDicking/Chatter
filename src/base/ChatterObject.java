package base;

/**
 * Because we need the ID in the InMemDbHandler and we do not want to duplicate code to much when looking for this id.
 * Now we just have to cast the object to a ChatterObject ot be able to access the id on that object.
 */
public abstract class ChatterObject {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
