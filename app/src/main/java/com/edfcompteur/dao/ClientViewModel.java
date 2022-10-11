package com.edfcompteur.dao;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.edfcompteur.model.Client;

public class ClientViewModel extends AndroidViewModel {

    private ClientRepository mClient;
    private final LiveData<Client> mAllClients;

    public ClientViewModel(Application application) {
        super(application);
        this.mClient = new ClientRepository(application);
        this.mAllClients = mClient.getAllClients();
    }

    public LiveData<Client> getmAllClients() {
        return mAllClients;
    }

    public void insert(Client client) {
        mClient.insert(client);
    }
}
