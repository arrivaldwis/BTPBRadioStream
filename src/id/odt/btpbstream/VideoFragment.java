package id.odt.btpbstream;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.pdf.PdfDocument;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.actionbarsherlock.app.SherlockFragment;

public class VideoFragment extends SherlockFragment {
	ProgressDialog pd;
	VideoView videoview;
	boolean play=false;
	WebView wv;
	String url = "http://tv.voyagearchipelago.com";
	String url2 = "https://www.dropbox.com/s/4cquai9bcbgz8oy/Risol.ess.mp4?dl=0";
	String url3 = "rtmp://103.16.198.186:1935/live/livestream1";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_video, container, false);
		//videoview = (VideoView) view.findViewById(R.id.VideoView);
		pd = new ProgressDialog(getActivity());
		pd.setMessage("Buffering...");
		pd.setCancelable(false);
		wv = (WebView) view.findViewById(R.id.webview);
		wv.getSettings().setPluginState(PluginState.ON);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl(url);
		
		/*try {
			pd.show();
			videoview.setMediaController(new MediaController(getActivity()));
			videoview.postInvalidateDelayed(100);
			videoview.setVideoURI(Uri.parse(url));
		} catch (Exception e) {
			pd.dismiss();
			e.printStackTrace();
		}
		videoview.setOnErrorListener(new MediaPlayer.OnErrorListener() {
			
			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				pd.dismiss();
				return false;
			}
		});
		videoview.requestFocus();
		videoview.setOnPreparedListener(new OnPreparedListener() {
			public void onPrepared(MediaPlayer mp) {
				pd.dismiss();
				play = true;
				videoview.start();
			}
		});*/
		return view;
	}
	@Override
	public void onPause() {
		super.onPause();
		//play = false;	
		//videoview.pause();
	}
}
