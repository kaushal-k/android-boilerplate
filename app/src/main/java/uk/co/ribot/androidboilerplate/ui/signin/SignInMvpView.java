package uk.co.ribot.androidboilerplate.ui.signin;

import uk.co.ribot.androidboilerplate.ui.base.MvpView;

/**
 * Created by kaushal on 5/10/17.
 */

public interface SignInMvpView extends MvpView {

    void displayUserName(String userName);

    void displayNoUser();

    void displayError();

}
