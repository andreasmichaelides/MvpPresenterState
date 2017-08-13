package app.mvp.com.presenterinstance;

/**
 * Created by westplay on 13/08/17.
 */

class MainPresenter implements DataProvider {

    private final MainView view;
    private PeristanceService peristanceService;
    private int counter = 0;
    private String message = "";

    MainPresenter(MainView view) {
        this.view = view;

//        peristanceService.subscribeGetData().subscribe(bundle -> bundle.putParcelable("sdfa", getData()));
    }

    void onKameKatiClicked() {
        message = "Hi";
        view.showMessage();
    }

    void increaseCounter() {
        counter++;
    }

    void clear() {

    }

    @Override
    public State getData() {
        return State.create(message, counter);
    }

    @Override
    public void restoreData(State state) {
        message = state.message();
        counter = state.counter();
    }
}
