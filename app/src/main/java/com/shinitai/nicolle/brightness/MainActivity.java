package com.shinitai.nicolle.brightness;

        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private SeekBar seekBar;
    private PictureThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.isshoni);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);

        thread = new PictureThread(imageView,bitmap);
        thread.start();

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                thread.adjustBrightness(seekBar.getProgress()-255);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
