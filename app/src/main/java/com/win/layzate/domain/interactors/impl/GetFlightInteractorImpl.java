package com.win.layzate.domain.interactors.impl;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightInteractor;
import com.win.layzate.domain.interactors.base.AbstractInteractor;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.repository.FlightRepository;

import io.reactivex.Observable;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class GetFlightInteractorImpl extends AbstractInteractor implements GetFlightInteractor {
    private FlightRepository mFlightRepository;
    private Callback mCallback;
    private String type;
    private String flightNumber;
    private String date;

    public GetFlightInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                   FlightRepository flightRepository, String type, String flightNumber, String date,
                                   Callback callback) {
        super(threadExecutor, mainThread);
        mFlightRepository = flightRepository;
        mCallback = callback;
        this.type = type;
        this.flightNumber = flightNumber;
        this.date = date;

    }

    @Override
    public void run() {
        final Observable<Flight> flight = mFlightRepository.getFlight(type, flightNumber, date);

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFlightRetrieved(flight);
            }
        });
    }
}
