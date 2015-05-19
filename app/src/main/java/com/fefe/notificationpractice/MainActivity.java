package com.fefe.notificationpractice;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 通知開始
                 * NotificationManagerCompat
                 * from
                 * 第一引数：Context
                 * notify
                 * 第一引数：通知のID（削除等で使用）
                 * 第二引数：通知するNotification
                 */
                NotificationManagerCompat.from(getApplicationContext()).notify(0, buildNotification());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Notification buildNotification(){
        /**
         * Notificationの作成
         */
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        //　上に出た時の通知
        builder.setTicker("Ticker");
        //　通知バーのアイコン
        builder.setSmallIcon(android.R.mipmap.sym_def_app_icon);
        //　タイトルと本文
        builder.setContentTitle("TITLE");
        builder.setContentText("MESSAGE");
        //　いつ通知するか
        builder.setWhen(System.currentTimeMillis());
        //　通知時の音、バイブ、ライト
        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS);
        //　タップで閉じる
        builder.setAutoCancel(true);
        return builder.build();
    }

}
