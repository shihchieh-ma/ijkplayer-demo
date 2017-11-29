package tv.danmaku.ijk.media.example.application;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import tv.danmaku.ijk.media.player.threadutils.task.AbsTask;
import tv.danmaku.ijk.media.player.threadutils.task.TaskManager;

/**
 * @author majes
 * @date 11/28/17.
 */

public class Application extends android.app.Application {
    public static final String videoPath =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() +
                    File.separator + "test.mp4";

    @Override
    public void onCreate() {
        super.onCreate();
        TaskManager.getNewInstance().onNext(new AbsTask() {
            @Override
            public void runInTask() {
                copyFilesFassets(getApplicationContext());
            }
        }).start();
    }

    private void copyFilesFassets(Context context) {
        try {
            InputStream is = context.getAssets().open("test.mp4");
            FileOutputStream fos = new FileOutputStream(new File(videoPath));
            byte[] buffer = new byte[2048];
            int byteCount = 0;
            while ((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            is.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
