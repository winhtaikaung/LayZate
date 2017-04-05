package com.win.layzate.presentation.presenters;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;

/**
 * Created by dmilicic on 12/23/15.
 */
public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
