package com.eisedo.eisedo.login;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Button;
import android.widget.RemoteViews;

import com.eisedo.eisedo.BuildConfig;
import com.eisedo.eisedo.R;
import com.eisedo.eisedo.background.AlarmCheckIntentService;
import com.eisedo.eisedo.background.AlarmJobService;
import com.eisedo.eisedo.broadcast_receiver.AlarmReceiver;
import com.eisedo.eisedo.broadcast_receiver.BootChangeReceiver;
import com.eisedo.eisedo.data.remote.Dao.PostSample;
import com.eisedo.eisedo.data.remote.EiseDoApiInterface;
import com.eisedo.eisedo.home.HomeActivity;
import com.eisedo.eisedo.util.ViewModelFactory;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    private LoginFragment loginFragment;

    private LoginViewModel loginViewModel;

    private Button btn_snooze;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCenter.start(getApplication(), "de79cba7-31ed-4940-91e8-f2cb280e2a2e", Analytics.class, Crashes.class);

//        networkCall();
//        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        telephonyManager.get
//        getSystemService(Context.NETWORK_STATS_SERVICE);

        setContentView(R.layout.activity_login);

//        getLocalIpAddress();


//        if (BuildConfig.DEBUG){
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            client.addInterceptor(interceptor);
//        }
//
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

        loginViewModel = obtainViewModel(LoginActivity.this);

        btn_snooze = findViewById(R.id.btn_snoze);

//        btn_snooze.setOnClickListener(v -> new Handler(msg -> false).postDelayed(() ->  checkStatus(),5000));

        if (savedInstanceState == null) {
            loginFragment = new LoginFragment();
        } else {
            loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag("login");
        }


        loginViewModel.getIntegerSingleLiveDataEvent().setValue(2);

        loginViewModel.getIntegerSingleLiveDataEvent().observe(this, integer -> {
            Log.d("VSlr", integer + "");
        });

        loginViewModel.getStringSingleLiveDataEvent().setValue("Value");

        loginViewModel.getStringSingleLiveDataEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("ObserveString", s);
            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.cl_container, loginFragment, "login").commit();


//        TimeZone timeZone = TimeZone.getDefault();

//        Log.d("TimeZone", timeZone.getDisplayName() + " "  + timeZone.getID() + " " + timeZone.getDisplayName(new Locale("en")) + " " + timeZone.getDisplayName(new Locale("ar")) + " " + timeZone.useDaylightTime());

//        ErrorReporter errorReporter  = ErrorReporter.getInstance();
//        errorReporter.Init(LoginActivity.this);

//        getAlarmIds(LoginActivity.this);

//        createChannel();

//        showNotification();

//        customNotification();

//        callBackground();

//        callJobService();

    }

    public interface OnConnectionTimeoutListener {
        void onConnectionTimeout();
    }

    OnConnectionTimeoutListener listener = new OnConnectionTimeoutListener() {
        @Override
        public void onConnectionTimeout() {
            Log.d("Conection", "Timeout");
        }
    };


    private okhttp3.Response onOnIntercept(Interceptor.Chain chain) throws IOException {
        try {
            okhttp3.Response response = chain.proceed(chain.request());

//            String content = "";

//            String content = UtilityMethods.convertResponseToString(response);
//            Log.d(TAG, lastCalledMethodName + " - " + content);
//            return response.newBuilder().body(ResponseBody.create(response.body().contentType(), content)).build();
        } catch (SocketTimeoutException exception) {
            exception.printStackTrace();
            if (listener != null)
                listener.onConnectionTimeout();
        }

        return chain.proceed(chain.request());
    }

    void disableBroadCastReceiver(Context context) {
        ComponentName receiver = new ComponentName(context, BootChangeReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    void enableBroadCastReceiver(Context context) {
        ComponentName receiver = new ComponentName(context, BootChangeReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

//    void checkStatus(){
//        AlarmUtil.checkAlarmStatus(null,LoginActivity.this);
//        AlarmUtil.cancelAlarm(null,LoginActivity.this);
//    }


    void callBackground() {

        Intent intent = new Intent(LoginActivity.this, AlarmCheckIntentService.class);
        startService(intent);

    }


    void callJobService() {
        Intent intent = new Intent(LoginActivity.this, AlarmJobService.class);
        AlarmJobService.enqueueWork(getApplicationContext(), AlarmJobService.class, 1, intent);
    }

    private static final String CHANNEL_ID = "CHANNEL IF";
    private static final String KEY_TEXT_REPLY = "key_text_reply";

    public void CustomNotification() {
        // Using RemoteViews to bind custom layouts into Notification
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.notification_alarm);

        // Set Notification Title
        String strtitle = "Custom Notification Title";
        // Set Notification Text
        String strtext = "Custom Notification Text";

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(this, HomeActivity.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
                // Set Icon
                .setSmallIcon(R.drawable.ic_inbox)
                // Set Ticker Message
                .setTicker("TickerMessage")
                // Dismiss Notification
                .setAutoCancel(true)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Set RemoteViews into Notification
                .setContent(remoteViews);

        // Locate and set the Image into customnotificationtext.xml ImageViews
        remoteViews.setImageViewResource(R.id.btn_dismiss, R.drawable.ic_launcher);
        remoteViews.setImageViewResource(R.id.btn_snoze, R.drawable.ic_delete);

        // Locate and set the Text into customnotificationtext.xml TextViews
        remoteViews.setTextViewText(R.id.title, "Custom Notitifaiton Titlr");
        remoteViews.setTextViewText(R.id.text, "Custome Notication c=test");

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());

    }


    void customNotification() {

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);


//        NotificationCompat.Builder mBuilder1 = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_launcher)
//                .setContentTitle("My notification Private")
//                .setContentText("Hello World!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
//                .setPriority(NotificationManager.IMPORTANCE_MAX);
//        notificationManager.notify(2, mBuilder1.build());

//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(LoginActivity.this);
        // Get the layouts to use in the custom notification
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_alarm);
//        RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.notification_large);

// Apply the layouts to the notification
//        NotificationCompat customNotification = new NotificationCompat.Builder(LoginActivity.this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_completed)
//                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
//                .setCustomContentView(notificationLayout)
//                .setCustomBigContentView(notificationLayoutExpanded)
//                .build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_completed)
                .setContentTitle("Custom Notification")
                .setCustomContentView(notificationLayout);
        notificationManager.notify(11, builder.build());
    }

    void headsUpNotification() {
        //set intents and pending intents to call service on click of "dismiss" action button of notification
        Intent dismissIntent = new Intent(this, LoginActivity.class);
//        dismissIntent.setAction(ACTION_DISMISS);
        PendingIntent piDismiss = PendingIntent.getService(this, 0, dismissIntent, 0);

//set intents and pending intents to call service on click of "snooze" action button of notification
        Intent snoozeIntent = new Intent(this, LoginActivity.class);
//        snoozeIntent.setAction(ACTION_SNOOZE);
        PendingIntent piSnooze = PendingIntent.getService(this, 0, snoozeIntent, 0);


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_completed)
                        .setContentTitle("Ping Notification")
                        .setContentText("Tomorrow will be your birthday.")
                        .setDefaults(Notification.DEFAULT_ALL) // must requires VIBRATE permission
                        .setPriority(NotificationCompat.PRIORITY_HIGH) //must give priority to High, Max which will considered as heads-up notification
                        .setAutoCancel(true)
                        .setNumber(3)
                        .addAction(R.drawable.ic_delete, getString(R.string.dismiss), piDismiss)
                        .addAction(R.drawable.ic_inbox, getString(R.string.snooze), piSnooze);


// Gets an instance of the NotificationManager service
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//to post your notification to the notification bar with a id. If a notification with same id already exists, it will get replaced with updated information.
        notificationManager.notify(0, builder.build());
    }

    void showNotification() {

        Intent snoozeIntent = new Intent(this, AlarmReceiver.class);
        snoozeIntent.setAction("ACTION_SNOOZE");
        snoozeIntent.putExtra("EXTRA_NOTIFICATION_ID", 0);
        PendingIntent snoozePendingIntent =
                PendingIntent.getBroadcast(this, 0, snoozeIntent, 0);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel("Reply")
                .build();

        PendingIntent replyPendingIntent =
                PendingIntent.getBroadcast(getApplicationContext(),
//                        conversation.getConversationId(),
                        0,
//                        getMessageReplyIntent(conversation.getConversationId()),
                        new Intent(),
                        PendingIntent.FLAG_UPDATE_CURRENT);

        // Create the reply action and add the remote input.
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.ic_launcher,
                        "Label", replyPendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();

//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_launcher)
//                .setContentTitle("My notification")
//                .setContentText("Much longer text that cannot fit one line...")
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText("Much longer text that cannot fit one line..."))
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setColor(ContextCompat.getColor(LoginActivity.this,R.color.red_light))
//                .addAction(action)
//                .addAction(R.mipmap.ic_launcher,"Snooz",snoozePendingIntent)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setVisibility(NotificationCompat.VISIBILITY_SECRET);
//        notificationManager.notify(1, mBuilder.build());

        NotificationCompat.Builder mBuilder1 = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("My notification Private")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        notificationManager.notify(2, mBuilder1.build());

//        NotificationCompat.Builder mBuilder2 = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_launcher)
//                .setContentTitle("My notification Public")
//                .setContentText("Hello World!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
//        notificationManager.notify(3, mBuilder2.build());

//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
//        builder.setSmallIcon(R.drawable.ic_completed)
////                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_poi))
////                .setColor(getResources().getColor(R.color.primary))
//                .setContentTitle("Hello")
////                .setContentIntent(notificationPendingIntent)
//                .setContentText(String.format(getString(R.string.notification)))
//                .setDefaults(Notification.DEFAULT_ALL)
////                .setStyle(bigText)
//                .setPriority(NotificationManager.IMPORTANCE_HIGH)
//                .addAction(action);
//        notificationManager.notify(4, builder.build());

    }

    void createChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private static final String sTagAlarms = ":alarms";


    private static List<Integer> getAlarmIds(Context context) {
        List<Integer> ids = new ArrayList<>();
        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            JSONArray jsonArray2 = new JSONArray(prefs.getString(context.getPackageName() + sTagAlarms, "[]"));

            for (int i = 0; i < jsonArray2.length(); i++) {
                ids.add(jsonArray2.getInt(i));
                Log.d("Ids", jsonArray2.getInt(i) + "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ids;
    }

    public void networkCall() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
//        client.connectTimeout(20, TimeUnit.SECONDS);
//        client.readTimeout(20,TimeUnit.SECONDS);se
//        client.connectTimeout(30,TimeUnit.SECONDS);
//        client.readTimeout(30,TimeUnit.SECONDS);
//        client.addInterceptor(chain -> onOnIntercept(chain));
//        client.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                return onOnIntercept(chain);
//            }
//        });
//
//        client.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                return onOnIntercept(chain);
//            }
//        });


        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.addInterceptor(interceptor);
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://paragonfs.co.uk:5500/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();


        EiseDoApiInterface eiseDoApiInterface = retrofit.create(EiseDoApiInterface.class);


        try {
//            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "eisedo");
            jsonObject.put("password", "eisedo");
            jsonObject.put("email", "eisedo@eisedo.com");
//            jsonArray.put(jsonObject);

            Map<String, Object> nameValuePairs = new HashMap<>();
            nameValuePairs.put("name", "eisedo");
            nameValuePairs.put("password", "eisedo");
            nameValuePairs.put("email", "eisedo@eisedo.com");


//            String json = jsonObject.toString();
//            TypedInput in = new TypedByteArray("application/json", json.getBytes("UTF-8"));
//            myService.postRawJson(in, callback);

            PostSample postSample = new PostSample();
            postSample.setName("eisedo");
            postSample.setPassword("eisedo");
            postSample.setEmail("eisedo@eisedo.com");

//            Log.d("JSonBo", jsonArray.toString());
            eiseDoApiInterface.callRawdata(postSample).enqueue(new Callback<JSONObject>() {
                @Override
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        eiseDoApiInterface.getUserRegistration("eisedo","eisedo","eisedo@eisedo.com").enqueue(new Callback<Sample>() {
//            @Override
//            public void onResponse(Call<Sample> call, Response<Sample> response) {
//                Log.d("Eisido ", response.body() + "");
//            }
//
//            @Override
//            public void onFailure(Call<Sample> call, Throwable t) {
//                Log.d("Eisedo", t.getMessage());
//            }
//        });

    }

    public static LoginViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(LoginViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public String getLocalIpAddress() {
        String TAG = "TAG";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                        Log.i(TAG, "***** IP=" + ip);
//                        return ip;
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e(TAG, ex.toString());
        }
        return null;
    }
}