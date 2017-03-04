package com.win.layzate.domain.interactors.impl;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightListInteractor;
import com.win.layzate.domain.interactors.base.AbstractInteractor;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.repository.FlightRepository;

import java.util.List;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class GetFlightListInteractorImpl extends AbstractInteractor implements GetFlightListInteractor {
    private FlightRepository mFlightRepository;
    private GetFlightListInteractor.Callback mCallback;

    public GetFlightListInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                   FlightRepository flightRepository,
                                       GetFlightListInteractor.Callback callback) {
        super(threadExecutor, mainThread);
        mFlightRepository = flightRepository;
        mCallback = callback;

    }

    @Override
    public void run() {
        final List<Flight> flights = mFlightRepository.getAllFlights();

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFlightlistretrieved(flights);
            }
        });
    }
}
