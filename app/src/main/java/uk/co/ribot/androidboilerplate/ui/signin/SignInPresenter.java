package uk.co.ribot.androidboilerplate.ui.signin;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import uk.co.ribot.androidboilerplate.data.DataManager;
import uk.co.ribot.androidboilerplate.ui.base.BasePresenter;

/**
 * Created by kaushal on 5/10/17.
 */

public class SignInPresenter extends BasePresenter<SignInMvpView> {

    private DataManager dataManager;

    @Inject
    public SignInPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(SignInMvpView mvpView) {
        super.attachView(mvpView);
    }

    public void loadUserName() {
        dataManager.getUserName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        // no action
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        if (s==null || s.equals("")) {
                            getMvpView().displayNoUser();
                        } else {
                            getMvpView().displayUserName(s);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getMvpView().displayError();
                    }

                    @Override
                    public void onComplete() {
                        // no action
                    }
                });
    }
}
