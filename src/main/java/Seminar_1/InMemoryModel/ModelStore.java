package Seminar_1.InMemoryModel;

import Seminar_1.ModelElements.Camera;
import Seminar_1.ModelElements.Flash;
import Seminar_1.ModelElements.PoligonalModel;
import Seminar_1.ModelElements.Scene;

import java.util.ArrayList;
import java.util.Collection;

public class ModelStore implements ModelChanger {
    private Collection<ModelChangedObserver> changedObservers = new ArrayList<>();
    private Collection<PoligonalModel> models;
    private Collection<Scene> scenes;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;


    @Override
    public void RegisterModelChanger(ModelChangedObserver observer) {
        changedObservers.add(observer);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver observer) {
        changedObservers.remove(observer);
    }

    @Override
    public void NotifyChange() {
        for (ModelChangedObserver observer: changedObservers
             ) {
            observer.ApplyUpdateModel();
        }
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public void setModels(Collection<PoligonalModel> models) {
        this.models = models;
    }

    public Collection<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(Collection<Scene> scenes) {
        this.scenes = scenes;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(Collection<Flash> flashes) {
        this.flashes = flashes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<Camera> cameras) {
        this.cameras = cameras;
    }

    public ModelStore(Collection<PoligonalModel> models, Collection<Scene> scenes, Collection<Flash> flashes, Collection<Camera> cameras) {
        this.models = models;
        this.scenes = scenes;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    //TODO метод получения сцены закоментирован чтобы не ругался на отсутствующий return
/*    public Scene getScene(int sceneId){

    }*/

}
