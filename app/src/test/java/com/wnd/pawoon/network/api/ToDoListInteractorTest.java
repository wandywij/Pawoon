package com.wnd.pawoon.network.api;

import com.wnd.pawoon.domain.ToDoListInteractor;
import com.wnd.pawoon.model.ToDoModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static org.mockito.Mockito.when;

/**
 * Created by Wandy on 6/26/17.
 */

public class ToDoListInteractorTest {

    @Mock
    PawoonNetworkServiceImpl networkService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getToDoList_shouldReturnCorrectValue() {
        ToDoModel mockedToDo = new ToDoModel(12, 28, "Vivo", true);
        List<ToDoModel> mockedListToDo = new ArrayList<ToDoModel>();
        mockedListToDo.add(mockedToDo);

        ToDoListInteractor toDoListInteractor = new ToDoListInteractor(networkService);
        when(networkService.getToDoList()).thenReturn(Observable.just(mockedListToDo));
        toDoListInteractor.getToDoList().subscribe(new Consumer<List<ToDoModel>>() {
            @Override
            public void accept(@NonNull List<ToDoModel> toDoModels) throws Exception {
                Assert.assertNotNull(toDoModels);
                Assert.assertEquals(1, toDoModels.size());
            }
        });
    }

    @Test
    public void checkIfNetworkServiceIsNull() {
        ToDoListInteractor toDoListInteractor = new ToDoListInteractor(networkService);
        Assert.assertNotNull(toDoListInteractor.getNetworkService());
    }
}
