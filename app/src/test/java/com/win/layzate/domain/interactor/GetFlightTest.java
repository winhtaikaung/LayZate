package com.win.layzate.domain.interactor;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightInteractor;
import com.win.layzate.domain.interactors.impl.GetFlightInteractorImpl;
import com.win.layzate.domain.model.Arrival;
import com.win.layzate.domain.model.Departure;
import com.win.layzate.domain.model.Flight;
import com.win.layzate.domain.repository.FlightRepository;
import com.win.layzate.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import io.reactivex.Observable;

import static org.mockito.Mockito.when;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class GetFlightTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private FlightRepository mFlightRepository;
    @Mock
    private GetFlightInteractor.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }


    @Test
    public void testGetFlight() throws Exception {

        Flight dummyFlight = new Flight("aa", "date", "departure", "http://www.flightstatus.com",
                new Departure("Yangon", "MM", "MidNight"), new Arrival("Yangon", "MM", "MidNight"));

        String type = "single";
        String flightNumber = "YH512";
        String date = "2017-03-10";

        Observable<Flight> dummyObservableFlight = Observable.just(dummyFlight);
        when(mFlightRepository.getFlight("single","YH512","2017-03-10"))
                .thenReturn(dummyObservableFlight);

        GetFlightInteractorImpl interactor = new GetFlightInteractorImpl(mExecutor, mMainThread, mFlightRepository,type,flightNumber,date, mMockedCallback);
        interactor.run();

        Mockito.verify(mFlightRepository).getFlight("single","YH512","2017-03-10");
        Mockito.verifyNoMoreInteractions(mFlightRepository);
        Mockito.verify(mMockedCallback).onFlightRetrieved(dummyObservableFlight);

    }
}
