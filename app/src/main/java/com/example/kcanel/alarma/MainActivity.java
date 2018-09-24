package com.example.kcanel.alarma;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity{

    TextView contenidoNotificacion;
    ImageView foto;

    String TAG = "ACA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenidoNotificacion = (TextView) findViewById(R.id.contenido);
        foto = (ImageView) findViewById(R.id.myImage);

        /*Obteniendo extras cuando notificación fué pushada*/
        if(getIntent().getExtras() != null){
                for( String key: getIntent().getExtras().keySet()){
                    String value = getIntent().getExtras().getString(key);

                    if(key.equalsIgnoreCase("image")){
                        Picasso.get().load(value).into(foto);
                    }

                    if(key.equalsIgnoreCase("video")){

                    }

                    if(key.equalsIgnoreCase("texto")){
                        contenidoNotificacion.append("\n"+key + ":"+value );
                    }
                }
        }

    }

    /*Recibiendo mensaje con la app abierta*/
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //Log.d(TAG, "From: " + remoteMessage.getFrom());
        //Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        if (remoteMessage.getData().size() > 0) {
            String image = remoteMessage.getData().get("image").toString();
            Log.d("HOLAAAA", image);
            //Picasso.get().load().into(foto);
            //Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                //scheduleJob();
            } else {
                // Handle message within 10 seconds
                //handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
           // Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }


}
