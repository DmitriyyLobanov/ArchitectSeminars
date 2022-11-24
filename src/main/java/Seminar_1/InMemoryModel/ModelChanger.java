package Seminar_1.InMemoryModel;

public interface ModelChanger {

    void RegisterModelChanger(ModelChangedObserver observer);
    void RemoveModelChanger(ModelChangedObserver observer);
    void NotifyChange();

}
