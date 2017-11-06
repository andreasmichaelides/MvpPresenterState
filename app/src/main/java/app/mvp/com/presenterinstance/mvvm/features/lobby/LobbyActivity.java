package app.mvp.com.presenterinstance.mvvm.features.lobby;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import app.mvp.com.presenterinstance.R;
import app.mvp.com.presenterinstance.mvvm.model.Response;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by andreas on 28/10/17.
 */

public class LobbyActivity extends DaggerAppCompatActivity {

    private static final String SELECTION_KEY = "SELECTION_KEY";

    @Inject
    LobbyViewModelFactory viewModelFactory;

    @BindView(R.id.greeting_textview)
    TextView greetingTextView;
    @BindView(R.id.loading_indicator)
    ProgressBar loadingIndicator;

    private LobbyViewModel viewModel;
    private ButtonSelection buttonSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activity);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LobbyViewModel.class);

        observeLoadingStatus();
        observeResponse();

        restoreInstance(savedInstanceState);
    }

    private void restoreInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            buttonSelection = (ButtonSelection) savedInstanceState.getSerializable(SELECTION_KEY);
            if (buttonSelection != null) {
                viewModel.restoreState(buttonSelection);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (buttonSelection != null) {
            outState.putSerializable(SELECTION_KEY, buttonSelection);
        }

        super.onSaveInstanceState(outState);
    }

    @OnClick(R.id.common_greeting_button)
    void onCommonGreetingButtonClicked() {
        viewModel.loadCommonGreeting();
        buttonSelection = ButtonSelection.COMMON;
    }

    @OnClick(R.id.lobby_greeting_button)
    void onLobbyGreetingButtonClicked() {
        viewModel.loadLobbyGreeting();
        buttonSelection = ButtonSelection.GREETING;
    }

    private void observeLoadingStatus() {
        viewModel.getLoadingStatus().observe(this, isLoading -> showLoading(isLoading));
    }

    private void observeResponse() {
        viewModel.getResponse().observe(this, response -> processResponse(response));
    }

    private void showLoading(boolean isLoading) {
        greetingTextView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
        loadingIndicator.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    private void processResponse(Response<String> response) {
        switch (response.status) {
            case SUCCESS:
                greetingTextView.setText(response.data);
                break;

            case ERROR:
                Toast.makeText(this, R.string.greeting_error, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
