package com.win.layzate.presentation.presenters.impl;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightListInteractor;
import com.win.layzate.domain.interactors.impl.GetFlightListInteractorImpl;
import com.win.layzate.domain.model.FlightList;
import com.win.layzate.domain.repository.FlightRepository;
import com.win.layzate.presentation.presenters.AbstractPresenter;
import com.win.layzate.presentation.presenters.FlightListPresenter;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by winhtaikaung on 24/4/17.
 */

public class FlightListPresenterImpl extends AbstractPresenter implements FlightListPresenter, GetFlightListInteractorImpl.Callback {

    private FlightListPresenter.View mView;
    private FlightRepository mFlightRepository;


    public FlightListPresenterImpl(Executor executor, MainThread mainThread, View view, FlightRepository flightRepository) {
        super(executor, mainThread);
        mView = view;
        mFlightRepository = flightRepository;
    }

    @Override
    public void onFlightListRetrieved(Observable<FlightList> flightList) {
        flightList.subscribe(new Consumer<FlightList>() {
            @Override
            public void accept(FlightList flightList) throws Exception {
                mView.onFlightListRetrieved(flightList);
            }
        });
    }

    @Override
    public void getFlightList(String type, String queryTime, boolean isDeparture, String portCode) {
        GetFlightListInteractor flightListInteractor = new GetFlightListInteractorImpl(mExecutor, mMainThread, mFlightRepository,
                type,queryTime,isDeparture,portCode,this);
        flightListInteractor.execute();
    }
}
