package com.win.layzate.domain.interactors.impl;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightListInteractor;
import com.win.layzate.domain.interactors.base.AbstractInteractor;
import com.win.layzate.domain.model.FlightList;
import com.win.layzate.domain.repository.FlightRepository;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class GetFlightListInteractorImpl extends AbstractInteractor implements GetFlightListInteractor {
    private FlightRepository mFlightRepository;
    private GetFlightListInteractor.Callback mCallback;

    private String mType;
    private String mQueryTime;
    private boolean mIsDeparture;
    private String mPortCode;


    public GetFlightListInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                       FlightRepository flightRepository,
                                       String type, String queryTime, boolean isDeparture, String portcode,
                                       GetFlightListInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        mFlightRepository = flightRepository;
        mCallback = callback;

        mType = type;
        mQueryTime = queryTime;
        mIsDeparture = isDeparture;
        mPortCode = portcode;

    }

    @Override
    public void run() {
        final Observable<FlightList> flightList = mFlightRepository.getAllFlights(mType, mQueryTime, mIsDeparture, mPortCode);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFlightlistretrieved(flightList);
            }
        });
    }
}
