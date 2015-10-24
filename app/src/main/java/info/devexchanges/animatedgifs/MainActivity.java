package info.devexchanges.animatedgifs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private GifView gifView;
    private GifDecoderView gifDecoderView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifView = (GifView) findViewById(R.id.gifview);
        webView = (WebView) findViewById(R.id.web_view);
        gifDecoderView = (GifDecoderView) findViewById(R.id.gif_decoder_view);

        webView.loadUrl("file:///android_asset/sample_gif_2.gif");
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        playGifByDecoderView();
    }

    private void playGifByDecoderView() {

        InputStream stream = null;
        try {
            stream = getAssets().open("sample_gif_3.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }

        gifDecoderView.playGif(stream);
    }
}