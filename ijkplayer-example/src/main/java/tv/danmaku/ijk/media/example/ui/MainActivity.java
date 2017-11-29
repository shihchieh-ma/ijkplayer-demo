package tv.danmaku.ijk.media.example.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

import tv.danmaku.ijk.media.example.R;
import tv.danmaku.ijk.media.example.application.Settings;

import static tv.danmaku.ijk.media.example.application.Application.videoPath;

/**
 * @author majes
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setvideopath);
        findViewById(R.id.gobtn).setOnClickListener(this);
        findViewById(R.id.setting).setOnClickListener(this);
        findViewById(R.id.netvideo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.gobtn: {
                File file = new File(videoPath);
                if (file.exists()) {
                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    intent.putExtra("videoPath", file.getPath());
                    intent.putExtra("videoTitle", file.getName());
                    startActivity(intent);
                }
                break;
            }
            case R.id.setting: {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.netvideo: {
                Intent intent = new Intent(MainActivity.this, SampleMediaActivity.class);
                startActivity(intent);
                break;
            }
            default: {
                break;
            }
        }
    }
}
