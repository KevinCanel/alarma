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

}
