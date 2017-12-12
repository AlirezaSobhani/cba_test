package alirezasobhani.example.com.cba;

import android.app.Activity;
import android.app.Application;

import alirezasobhani.example.com.cba.utils.ConnectivityUtils;

public class MyApplication extends Application {

    private ApplicationLifecycleHandler applicationLifecycleHandler;
    private Activity currentActivity;

    private ConnectivityUtils connectivityUtilsInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationLifecycleHandler = new ApplicationLifecycleHandler(this);
        registerActivityLifecycleCallbacks(applicationLifecycleHandler);
        registerComponentCallbacks(applicationLifecycleHandler);
    }

    public void setCurrentActivity(Activity activity) {
        this.currentActivity = activity;
    }

    public Activity getCurrentActivity() {
        return currentActivity;
    }

    public ConnectivityUtils getConnectivityUtilsInstance() {
        if(connectivityUtilsInstance == null) {
            connectivityUtilsInstance = new ConnectivityUtils(this);
        }
        return connectivityUtilsInstance;
    }
}
