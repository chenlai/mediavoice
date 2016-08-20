package lchen.mediavoice;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static String TAGM = "MediaVoice";

    NdkUtil handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handle = new NdkUtil();
        handle.setJVM(this);

        //init(this);
    //    add(1, 2);
    }

    /** Called when the user clicks the Send button */
    public void startVoice(View view) {

        handle.logInfo();
        handle.start();
       // startJNI();
        Log.d(TAGM, "start OK");

    }

    public void stopVoice(View view){
      //  stopJNI();
        handle.stop();
        Log.d(TAGM, "stop OK");
    }

//    native void init(Context context);
//    native void startJNI();
//    native void stopJNI();
//    native int add(int x, int y);





}
