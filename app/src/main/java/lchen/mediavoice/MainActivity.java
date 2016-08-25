package lchen.mediavoice;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String TAGM = "MediaVoice";

    private CheckBox loopback;

    NdkUtil handle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handle = new NdkUtil();
        handle.setJVM(this);

        addListenerOnCheck();

        //init(this);
    //    add(1, 2);
    }
    // method for CheckBox1 - Java
    private void addListenerOnCheck() {
        loopback = (CheckBox) findViewById(R.id.checkBox);
        loopback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                handle.loop(loopback.isChecked());

                StringBuffer result = new StringBuffer();
                result.append("loopback set : ").append(loopback.isChecked());
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_LONG).show();

            }
        });

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
