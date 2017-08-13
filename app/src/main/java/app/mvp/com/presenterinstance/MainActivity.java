package app.mvp.com.presenterinstance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class MainActivity extends AppCompatActivity implements MainView, PeristanceService {

    public static final String SERVICE_DATA = "ServiceData";
    private MainPresenter mainPresenter;
    private DataProvider dataProvider;

    private Subject<Bundle> saveState = PublishSubject.create();
    private Subject<Bundle> restoreState = PublishSubject.create();
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        dataProvider = mainPresenter = new MainPresenter(this);
        disposables.addAll(
                saveState.subscribe(bundle -> bundle.putParcelable(SERVICE_DATA, dataProvider.getData())),
                restoreState.map(bundle -> (State) savedInstanceState.getParcelable(SERVICE_DATA))
                        .doOnNext(state -> Toast.makeText(this, state.message() + " - " + state.counter(), Toast.LENGTH_SHORT).show())
                        .subscribe(state -> dataProvider.restoreData(state))
        );

        if (savedInstanceState != null) {
            restoreState.onNext(savedInstanceState);
        }
    }


    @Override
    public void showMessage() {
        Toast.makeText(this, "Pellamos", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.kameKatiButton)
    void onKameKati() {
        mainPresenter.onKameKatiClicked();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.clear();
        disposables.clear();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mainPresenter.increaseCounter();
        saveState.onNext(outState);
        super.onSaveInstanceState(outState);
    }

    ///////////////////////////////////////////////////////////////////////////
    // PeristanceService
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void saveState(DataProvider dataProvider) {
//        saveState.onNext();
    }

    @Override
    public void restoreState() {

    }

    @Override
    public Observable<Bundle> subscribeGetData() {
        return saveState;
    }
}
