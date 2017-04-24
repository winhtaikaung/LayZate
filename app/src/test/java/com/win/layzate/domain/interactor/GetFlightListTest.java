package com.win.layzate.domain.interactor;

import com.win.layzate.domain.executor.Executor;
import com.win.layzate.domain.executor.MainThread;
import com.win.layzate.domain.interactors.GetFlightListInteractor;
import com.win.layzate.domain.interactors.impl.GetFlightListInteractorImpl;
import com.win.layzate.domain.model.FlightItem;
import com.win.layzate.domain.model.FlightList;
import com.win.layzate.domain.repository.FlightRepository;
import com.win.layzate.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

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
        GetFlightListInteractorImpl interactor = new GetFlightListInteractorImpl(mExecutor, mMainThread, mFlightRepository,"list","8",false,"RGN", mMockedCallback);
        interactor.run();

        Mockito.verify(mFlightRepository).getAllFlights("list","8",false,"RGN");
        Mockito.verifyNoMoreInteractions(mFlightRepository);
//        Mockito.verify(mMockedCallback).onFlightListRetrieved();
    }

    @Test
    public void testGetFlightList() throws Exception {

        List<FlightItem> dummyFlightlist = new ArrayList<>();
        dummyFlightlist.add(new FlightItem("trackingUrl", "number", "carrier", "originCode","originName","time","status","remark"));
        dummyFlightlist.add(new FlightItem("trackingUrl", "number", "carrier", "originCode","originName","time","status","remark"));
        dummyFlightlist.add(new FlightItem("trackingUrl", "number", "carrier", "originCode","originName","time","status","remark"));

        FlightList flightlistmodel = new FlightList(dummyFlightlist);

        Observable<FlightList> dummyObservablelist = Observable.just(flightlistmodel);

        when(mFlightRepository.getAllFlights("list","8",false,"RGN"))
                .thenReturn(dummyObservablelist);

        GetFlightListInteractorImpl interactor = new GetFlightListInteractorImpl(mExecutor, mMainThread, mFlightRepository,"list","8",false,"RGN", mMockedCallback);
        interactor.run();

        Mockito.verify(mFlightRepository).getAllFlights("list","8",false,"RGN");
        Mockito.verifyNoMoreInteractions(mFlightRepository);
        Mockito.verify(mMockedCallback).onFlightListRetrieved(dummyObservablelist);

    }
}
