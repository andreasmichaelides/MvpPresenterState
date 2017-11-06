package app.mvp.com.presenterinstance.mvvm.core.dagger;

public interface Component<T> {
    void inject(T objectToBeInjectedWithModules);
}
