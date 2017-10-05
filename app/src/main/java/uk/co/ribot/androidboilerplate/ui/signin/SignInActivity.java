package uk.co.ribot.androidboilerplate.ui.signin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ribot.androidboilerplate.R;
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity;

/**
 * Created by kaushal on 5/10/17.
 */

public class SignInActivity extends BaseActivity implements SignInMvpView {

    @Inject SignInPresenter signInPresenter;

    @BindView(R.id.user_name) TextView userName;

    public static Intent getNewIntent(Context context) {
        Intent i = new Intent(context, SignInActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        activityComponent().inject(this);
        ButterKnife.bind(this);

        signInPresenter.attachView(this);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInPresenter.loadUserName();
                userName.setOnClickListener(null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signInPresenter.detachView();
    }

    public void displayUserName(String userNameToBeDisplayed) {
        userName.setText(userNameToBeDisplayed);
    }

    public void displayNoUser() {
        userName.setText("No user signed in");
    }

    public void displayError() {
        userName.setText("Error in getting user name");
    }

}
