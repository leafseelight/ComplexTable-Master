package com.leaf.complextable;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.Iterator;
import java.util.List;

/**
 * Data:2016/5/27 15:38
 * Created by WCP
 */
public class AppContext extends Application {

    private static AppContext app = null;

    public static AppContext getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        if (isInit()) {
            super.onCreate();
            app = this;
        }
    }

    /**
     * 是否多次初始化
     *
     * @return
     */
    private boolean isInit() {
        int pid = android.os.Process.myPid();
        String processAppName = getAppProcessName(pid, this.getApplicationContext());
        Log.i("", "process app name : " + processAppName);

        // 如果app启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的app会在以包名为默认的process name下运行，如果查到的process name不是app的process name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(this.getPackageName())) {
            Log.i("", "enter the service process!");

            // 则此application::onCreate 是被service 调用的，直接返回
            return false;
        }
        return true;
    }

    /**
     * check the application process name if process name is not qualified, then we think it is a service process and we will not init SDK
     *
     * @param pID
     * @return
     */
    public String getAppProcessName(int pID, Context context) {
        String processName = null;
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = context.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                    // Log.d("Process", "Id: "+ info.pid +" ProcessName: "+
                    // info.processName +"  Label: "+c.toString());
                    // processName = c.toString();
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
                // Log.d("Process", "Error>> :"+ e.toString());
            }
        }
        return processName;
    }

}
