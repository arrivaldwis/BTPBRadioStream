package id.odt.btpbstream;

import java.io.IOException;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;

public class RadioFragment extends SherlockFragment {
	Button btncontrolradio;
	String[] url = {
			"http://btpb-radio.for-the.biz:8000/listen.mp3",
			"http://btpb-radio.for-the.biz:8000/listen.mp3.m3u",
			"http://player.mdn.stream24.net/webradioplayer/livestream.php?servertyp=IC&server=btpb-radio.for-the.biz&port=8000&mp=/listen.mp3&lang=en&autostart=1&cut=0&station=" };
	private MediaPlayer player;
	boolean isplay = false;
	ProgressDialog pd;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_radio, container, false);
		pd = new ProgressDialog(getActivity());
		pd.setCancelable(false);
		pd.setMessage("Buffering...");
		initializeMediaPlayer();
		btncontrolradio = (Button) view.findViewById(R.id.btncontrolradio);
		btncontrolradio.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String text = "";
				Drawable draw = null;
				Resources res = getActivity().getResources();
				if (!isplay) {
					draw = res.getDrawable(R.drawable.stop);
					startPlaying();
					text = "STOP";
					isplay = true;
				} else {
					draw = res.getDrawable(R.drawable.play);
					stopPlaying();
					text = "PLAY";
					isplay = false;
				}
				btncontrolradio.setText(text);
			}
		});
		player.setOnErrorListener(new MediaPlayer.OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				pd.dismiss();
				return false;
			}
		});
			return view;
	}

	public void initializeMediaPlayer() {
		player = new MediaPlayer();
		try {
			player.setDataSource(url[0]);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startPlaying() {
		try {
			player.prepareAsync();
			pd.show();
			player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					pd.dismiss();
					player.start();
				}
			});
		} catch (Exception e) {
			pd.dismiss();
			e.printStackTrace();
		}
	}

	public void stopPlaying() {
		if (player.isPlaying()) {
			player.stop();
			player.release();
			initializeMediaPlayer();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (player.isPlaying()) {
			player.stop();
		}
	}

}
