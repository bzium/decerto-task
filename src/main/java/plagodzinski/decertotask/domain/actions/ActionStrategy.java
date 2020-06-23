package plagodzinski.decertotask.domain.actions;

public interface ActionStrategy<T> {
    boolean accept(ActionType actionType);
    T calculate();
}
