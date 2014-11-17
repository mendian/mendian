package com.example.ceshiurl.http;

import android.content.Context;

import org.apache.http.Header;  
import com.loopj.android.http.AsyncHttpResponseHandler;

public class LoadResponseLoginouthandler extends AsyncHttpResponseHandler {
	private Context context;
	private LoadDatahandler mHandler;

	public LoadResponseLoginouthandler(Context context,
			LoadDatahandler mHandler) {
		this.context = context;
		this.mHandler = mHandler;
	}

	@Override
	public void onStart() {
		super.onStart();
		mHandler.onStart();
	}

	@Override
	public void onFailure(Throwable error, String content) {
		super.onFailure(error, content);
		mHandler.onFailure(""+error, "网络连接超时");
	
	}

	@Override
	public void onFinish() {
		super.onFinish();
		mHandler.onFinish();
	}

	@Override
	public void onSuccess(int statusCode, Header[] headers, String content) {
		super.onSuccess(statusCode, headers, content);
		System.out.println("得到的返回码" + statusCode);
		try {
			switch (statusCode) {
			case 200:
				mHandler.onSuccess(content);
//				System.out.println("返回的内容" + content);
				break;
			case 401:
				onFailure("401", "没有登录");

				break;
			case 404:
				onFailure("404", "没有权限");
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 出错
	 * 
	 * @param error
	 * @param errorMessage
	 */
	public void onFailure(String error, String errorMessage) {
		if (errorMessage != null) {
			mHandler.onFailure(error, errorMessage);
		}
	}


	 

}
