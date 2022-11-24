package Seminar_1.ModelElements;

import java.util.Collection;

public class Scene {

    private static int counter = 0;
    private int id;
    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;

    public int getId() {
        return id;
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public void setModels(Collection<PoligonalModel> models) {
        this.models = models;
    }

    public void setFlashes(Collection<Flash> flashes) {
        this.flashes = flashes;
    }

    {
        id = ++counter;
    }

    public Scene(Collection<PoligonalModel> models, Collection<Flash> flashes) {
        this.models = models;
        this.flashes = flashes;
    }

    //TODO реализовать поведение
}
