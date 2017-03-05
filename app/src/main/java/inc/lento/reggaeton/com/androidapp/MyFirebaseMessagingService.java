package inc.lento.reggaeton.com.androidapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        String[] content = remoteMessage.getNotification().getBody().split(",");

        Location locationA = new Location("A");

        Log.i("Latitud, longitud:", remoteMessage.getNotification().getBody());

        locationA.setLatitude(Double.parseDouble(content[0]));
        locationA.setLongitude(Double.parseDouble(content[1]));

        MainActivity mainActivity = new MainActivity();
        Location locationB = mainActivity.getLocation(null);

        float distance = locationA.distanceTo(locationB);

        Log.i("DISTANCIA", String.valueOf(distance));

        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        if(distance > 1000){
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(getResources().getString(R.string.beware))
                            .setContentText(getResources().getString(R.string.beware_info));

            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);

            // Add as notification
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());
        }
    }
}