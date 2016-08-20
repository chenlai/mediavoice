package lchen.mediavoice;

import android.util.Log;
import android.content.Context;

/**
 * Created by laichen on 8/12/16.
 */
public class NdkUtil {

    static String TAGM = "MediaVoice";

    public void logInfo(){
        Log.d(TAGM, "logInfo: Ndk Class" + add(1,2));
    }


    public void start(){

        startJNI();
    }
    public void stop(){

        stopJNI();
    }


    public void setJVM(Context context){

        init(context);

    }

    native int add(int x, int y);
    native void startJNI();
    native void stopJNI();
    native void init(Context context); 

    static {
        //     System.loadLibrary("gsmediatest-jni");

        System.loadLibrary("mediavoice-jni");
//        System.loadLibrary("ndktest");
    }

}
