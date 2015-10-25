package com.example.silentechoes.dema.Sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Gatorade on 09/10/2015.
 */
public class AuthService extends Service {

    private Authenticator mAuthenticator;

    @Override
    public void onCreate() {
        // Create a new authenticator object
        mAuthenticator = new Authenticator(this);
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mAuthenticator.getIBinder();
    }
}
