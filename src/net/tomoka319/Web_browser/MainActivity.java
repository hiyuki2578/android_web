package net.tomoka319.Web_browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.File;

public class MainActivity extends Activity {

	private ProgressBar progressBar;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
		super.onCreate(savedInstanceState);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		CookieSyncManager.createInstance(getApplicationContext());
		CookieManager cm = CookieManager.getInstance();
		cm.setAcceptCookie(true);
		cm.removeExpiredCookie();
	
		setContentView(R.layout.main);
		progressBar =(ProgressBar) findViewById(R.id.progressbar);
		TextView textView = (TextView) findViewById(R.id.textView);
		//44 爆音で名前が聞こえません 2013/03/24(日) 14:01:31.76 ID:On0YHxwv0
		//シコリ続けるのだ…
		//
		//45 爆音で名前が聞こえません 2013/03/24(日) 14:02:12.85 ID:On0YHxwv0
		//ごめん誤爆した
		//
		WebView  myWebView = (WebView) findViewById(R.id.webView);
		setupGeolocation(myWebView);
		setupWebStorage(myWebView);
		//アタシのいくじなし～＞＜)
		myWebView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				TextView textView = (TextView) findViewById(R.id.textView);
				textView.setText(url);
				//プログレスバー表示
				progressBar.setVisibility(View.VISIBLE);
				textView.setVisibility(View.VISIBLE);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				TextView textView = (TextView) findViewById(R.id.textView);
				WebView myWebView = (WebView) findViewById(R.id.webView);
				textView.setText(myWebView.getTitle() + " " + url);
				//プログレスバー非表示
				progressBar.setVisibility(View.GONE);
				textView.setVisibility(View.GONE);
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}
		});

		myWebView.setWebChromeClient(new WebChromeClient(){
			
			
			
				
			@Override
			public void onProgressChanged(WebView view, int progress){
				progressBar.setProgress(progress);
			}
		});
		WebSettings webSettings = myWebView.getSettings();
		//＼ぐるぐる／スクロールバー＼ぐるぐる／
		myWebView.setVerticalScrollbarOverlay(true);
		//この文は預言書に書かれています！ そして先祖代々受け継がれるアカシックレコードにも書かれています！ つまりこの文は必然だったんだよ！！
		//ΩΩΩ＜ﾅ､ﾅﾝﾀﾞｯﾃｰ!?
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		//ラジオネーム「恋する☆Primちゃんっ!!」から
		//気になるあの人が私の弾幕に気付いてくれません
		//あたしはいくじなしでしょうか？ぐぬぬ、あしたこそ……
		
		//Primちゃん！『あしたって今さッ！』
		webSettings.setBuiltInZoomControls(true);
		//えいニャ！えいニャ！
		webSettings.setDomStorageEnabled(true);
		//／にゃん☆にゃん☆＼
		webSettings.setGeolocationEnabled(true);
		//                    ＼  
		//         ( ﾟдﾟ ）  ／ 
		//         |  ヽﾉヽ／＼＜ｼﾝｺﾞｰﾊﾟｰｿﾝﾌﾟﾚｰｲ 
		//          ＞＞  ＼／
		boolean checkboxValue = spf.getBoolean("EnableJavaScripts", false);
		if(checkboxValue == true){
			webSettings.setJavaScriptEnabled(true);
		}
		//ホームページが映るコード
		boolean checkboxValue1 = spf.getBoolean("homepage-select",false);
		if (checkboxValue1 == true){
			String homeUrl = spf.getString("home_Url","https://www.google.com/");
			myWebView.loadUrl(homeUrl);
		}else{
			String homeValue = spf.getString("home_preference", "https://www.google.com/");
			myWebView.loadUrl(homeValue);
			textView.setBackgroundColor(Color.WHITE);
			textView.setText("LoadingNow");
		}

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		TextView textView = (TextView) findViewById(R.id.textView);
		WebView webView = (WebView)findViewById(R.id.webView);
		int id = item.getItemId();
		if (id == R.id.quit){
			//Activityの終了
			this.finish();
		}
		if (id == R.id.back){
			//戻る
			webView.goBack();
			return true;
		}
		if (id == R.id.forward){
			//進む
			webView.goForward();
			return true;
		}
		if (id == R.id.home){
			//home
			SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
			boolean checkboxValue1 = spf.getBoolean("homepage-select",false);
			if (checkboxValue1 == true)
			{
				String homeUrl = spf.getString("home_Url","https://www.google.com");
				webView.loadUrl(homeUrl);
			}else{
				String homeValue = spf.getString("home_preference", "https://www.google.com");
				webView.loadUrl(homeValue);
				textView.setBackgroundColor(Color.WHITE);
				textView.setText("LoadingNow");
			}
			
		}
		if (id == R.id.reload){
		//reload
		webView.reload();
		return true;
		}
		if (id == R.id.setting){
			Intent intent = new Intent(this, Preference.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public boolean onKeyDown( int keyCode, KeyEvent event){
		WebView webview = (WebView)findViewById(R.id.webView);
		if(keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
			webview.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onResume(){
		super.onResume();
		CookieSyncManager.getInstance().startSync();
	}
	@Override
	protected void onPause(){
		super.onPause();
		CookieSyncManager.getInstance().stopSync();
	}
	private void setupGeolocation(WebView webView){
		WebSettings ws = webView.getSettings();
		ws.setGeolocationEnabled(true);
		File databaseDir= getDir("databases", Context.MODE_PRIVATE);
		if (!databaseDir.exists()){
			databaseDir.mkdirs();
		}
		ws.setGeolocationDatabasePath(databaseDir.getPath());
	}
	
	@SuppressWarnings("deprecation")
	private void setupWebStorage(WebView webview){
	        WebSettings ws =webview.getSettings();
		ws.setDatabaseEnabled(true);
		ws.setDomStorageEnabled(true);
	        if(Build.VERSION_CODES.JELLY_BEAN_MR2 <= Build.VERSION.SDK_INT){
			File databaseDir = getDir("database", Context.MODE_PRIVATE);
			if(!databaseDir.exists()){
				databaseDir.mkdirs();
			}
			ws.setDatabasePath(databaseDir.getPath());
		}
	}
}