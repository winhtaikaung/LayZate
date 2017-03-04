package com.win.layzate.domain.interactor;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightListInteractor;
import com.win.layzate.domain.interactors.impl.GetFlightListInteractorImpl;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by winhtaikaung on 4/3/17.
 */

public class GetFlightListTest {

    private MainThread mMainThread;
    @Mock
    private Executor mExecutor;
    @Mock
    private FlightRepository mFlightRepository;
    @Mock
    private GetFlightListInteractor.Callback mMockedCallback;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }

    @Test
    public void testCostNotFound() throws Exception {
        GetFlightListInteractorImpl interactor = new GetFlightListInteractorImpl(mExecutor, mMainThread, mFlightRepository, mMockedCallback);
        interactor.run();

        Mockito.verify(mFlightRepository).getAllFlights();
        Mockito.verifyNoMoreInteractions(mFlightRepository);
//        Mockito.verify(mMockedCallback).onFlightlistretrieved();
    }

    @Test
    public void testGetFlightList() throws Exception {

        List<Flight> dummyFlightlist = new ArrayList<>();
        dummyFlightlist.add(new Flight("aa", "date", "departure", "http://www.flightstatus.com",
                new Departure("Yangon", "MM", "MidNight"), new Arrival("Yangon", "MM", "MidNight")));
        dummyFlightlist.add(new Flight("aa", "date", "departure", "http://www.flightstatus.com",
                new Departure("Yangon", "MM", "MidNight"), new Arrival("Yangon", "MM", "MidNight")));
        dummyFlightlist.add(new Flight("aa", "date", "departure", "http://www.flightstatus.com",
                new Departure("Yangon", "MM", "MidNight"), new Arrival("Yangon", "MM", "MidNight")));

        when(mFlightRepository.getAllFlights())
                .thenReturn(dummyFlightlist);

        GetFlightListInteractorImpl interactor = new GetFlightListInteractorImpl(mExecutor, mMainThread, mFlightRepository, mMockedCallback);
        interactor.run();

        Mockito.verify(mFlightRepository).getAllFlights();
        Mockito.verifyNoMoreInteractions(mFlightRepository);
        Mockito.verify(mMockedCallback).onFlightlistretrieved(dummyFlightlist);

    }
}
