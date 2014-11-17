package com.example.ceshiurl.http;

import android.content.Context;

public class WaitingView {
	private static CustomProgressDialog progressDialog = null;
	public static void startProgressDialog(Context mContext){
		if (progressDialog == null || progressDialog.getWindow() == null){
			progressDialog = CustomProgressDialog.createDialog(mContext);
			progressDialog.setMessage("");
		}
		
    	progressDialog.show();
	}
	
	public  static  void stopProgressDialog(){
		
		if (progressDialog != null&&progressDialog.getWindow()!=null){
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
}
