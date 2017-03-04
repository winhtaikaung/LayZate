package com.win.layzate.domain.interactors.impl;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightInteractor;
import com.win.layzate.domain.interactors.base.AbstractInteractor;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.repository.FlightRepository;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class GetFlightInteractorImpl extends AbstractInteractor implements GetFlightInteractor {
    private FlightRepository mFlightRepository;
    private Callback mCallback;

    public GetFlightInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                   FlightRepository flightRepository,
                                   Callback callback) {
        super(threadExecutor, mainThread);
        mFlightRepository = flightRepository;
        mCallback = callback;

    }

    @Override
    public void run() {
        final Flight flight = mFlightRepository.getFlight();

        // Show costs on the main thread
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFlightretrieved(flight);
            }
        });
    }
}
