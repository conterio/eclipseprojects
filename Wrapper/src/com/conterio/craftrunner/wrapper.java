package com.conterio.craftrunner;

import com.conterio.craftrunner.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class wrapper extends Activity
{
	WebView webview;
	Audio audio = new Audio(this);

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
      super.onConfigurationChanged(newConfig);
    }

   
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        
        webview = (WebView) findViewById(R.id.webview);
        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setBuiltInZoomControls(false);
        webview.setVerticalScrollBarEnabled(false);
        webview.setHorizontalScrollBarEnabled(false);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            webview.getSettings().setDatabasePath("/data/data/" + webview.getContext().getPackageName() + "/databases/");
        }
        
        
        
        Display display = getWindowManager().getDefaultDisplay(); 
        double ratio = display.getWidth() / 9.7;
        webview.setInitialScale((int) ratio);
        webview.loadUrl("file:///android_asset/menu.html?androidapp");
        webview.addJavascriptInterface(audio, "Audio");
	  

        final Context myApp = this;  
  
        webview.setWebChromeClient(new WebChromeClient()
        {  
        	@Override  
        	public boolean onJsAlert(WebView view, String url,
        			String message, final android.webkit.JsResult result)  
        	{  
        		new AlertDialog.Builder(myApp)  
        		.setTitle("JavaScript Alert").setMessage(message)  
        		.setPositiveButton(android.R.string.ok,  
                    new AlertDialog.OnClickListener()  
                    {  
                        public void onClick(DialogInterface dialog, int which)  
                        {  
                            result.confirm();  
                        }  
                    })

                .setCancelable(false).create().show();  
  
        		return true;  
        	};  
        });
    }
}
