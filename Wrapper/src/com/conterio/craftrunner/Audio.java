package com.conterio.craftrunner;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.webkit.JavascriptInterface;

public class Audio {
	Context mContext;
	MediaPlayer mp,mc;

	Audio(Context c) {
		mContext = c;
	}
	
	@JavascriptInterface
	public void stop(){
		mp.stop();
	}
	
	@JavascriptInterface
	public void playAudio(String aud) {
		try {
			AssetFileDescriptor fileDescriptor = mContext.getAssets().openFd(
					aud);
			mp = new MediaPlayer();
			mp.setDataSource(fileDescriptor.getFileDescriptor(),
					fileDescriptor.getStartOffset(), fileDescriptor.getLength());
			fileDescriptor.close();
			mp.prepare();
			mp.setVolume(.2f,.2f);
			mp.start();
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@JavascriptInterface
	public void playClip(String aud) throws InterruptedException {
		try {
			AssetFileDescriptor fileDescriptor = mContext.getAssets().openFd(
					aud);
			
			mc = new MediaPlayer();
			mc.setDataSource(fileDescriptor.getFileDescriptor(),
					fileDescriptor.getStartOffset(), fileDescriptor.getLength());
			fileDescriptor.close();
			mc.prepare();
			mc.setVolume(6f, 6f);
			mc.start();
			
			
					
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@JavascriptInterface
	public void pauseAudio() {

		try {
			mp.pause();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@JavascriptInterface
	public void unMute() {

		try {

			mp.start();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@JavascriptInterface
	public void pauseAll() {

		try {
			mc.pause();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}