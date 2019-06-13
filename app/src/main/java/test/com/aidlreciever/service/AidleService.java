package test.com.aidlreciever.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import test.com.aidlclient.Data;
import test.com.aidlclient.IMyAidlInterface;

import java.util.ArrayList;
import java.util.List;


public class AidleService extends Service {


    private void log(String message) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        log("Received start command.");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        log("Received binding.");
        return  iMyAidlInterface;
    }
    IMyAidlInterface.Stub iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(String aString) throws RemoteException {

        }

        @Override
        public Data[] getData() throws RemoteException {
            Data[] data = new Data[4];
            data[0] = new Data("test");
            data[1] = new Data("test");
            data[2] = new Data("test");
            data[3] = new Data("test");
            return data;
        }
    };

}
