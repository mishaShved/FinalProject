package by.tc.epam.model.entity;

public final class EntityBuilder {

    private static EntityBuilder ourInstance = new EntityBuilder();

    public static EntityBuilder getInstance() {
        return ourInstance;
    }

    private EntityBuilder() {
    }

    public Event createEvent(){
        return new Event();
    }

    public Odd createOdd(){
        return new Odd();
    }

    public Stacke createStacke(){
        return new Stacke();
    }

    public BukmakerDate createDate(){
        return new BukmakerDate();
    }

}
