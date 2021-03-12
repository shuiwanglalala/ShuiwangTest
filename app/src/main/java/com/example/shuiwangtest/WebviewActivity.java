package com.example.shuiwangtest;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.LogUtils;

import java.security.cert.LDAPCertStoreParameters;

public class WebviewActivity extends AppCompatActivity {

    private static final String TAG = "WebviewActivity";
//    String url = "http://www.baidu.com";
    String url = "http://m.ctrip.com/";
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = findViewById(R.id.webview);
        findViewById(R.id.title_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl(url);
            }
        });

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                LogUtils.dTag(TAG, "shouldOverrideUrlLoading", view, request);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                LogUtils.dTag(TAG, "onPageStarted", view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                LogUtils.dTag(TAG, "onPageFinished", view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                LogUtils.dTag(TAG, "onLoadResource", view, url);
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                LogUtils.dTag(TAG, "onPageCommitVisible", view, url);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                LogUtils.dTag(TAG, "shouldInterceptRequest", view, request);
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                LogUtils.dTag(TAG, "onReceivedError", view, request, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                LogUtils.dTag(TAG, "onReceivedHttpError", view, request, errorResponse);
            }

            @Override
            public void onFormResubmission(WebView view, Message dontResend, Message resend) {
                super.onFormResubmission(view, dontResend, resend);
                LogUtils.dTag(TAG, "onFormResubmission", view, dontResend, resend);
            }

            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                super.doUpdateVisitedHistory(view, url, isReload);
                LogUtils.dTag(TAG, "doUpdateVisitedHistory", view, url, isReload);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                LogUtils.dTag(TAG, "onReceivedSslError", view, handler, error);
            }

            @Override
            public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
                super.onReceivedClientCertRequest(view, request);
                LogUtils.dTag(TAG, "onReceivedClientCertRequest", view, request);
            }

            @Override
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
                super.onReceivedHttpAuthRequest(view, handler, host, realm);
                LogUtils.dTag(TAG, "onReceivedHttpAuthRequest", view, handler, host, realm);
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                LogUtils.dTag(TAG, "shouldOverrideKeyEvent", view, event);
                return super.shouldOverrideKeyEvent(view, event);
            }

            @Override
            public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
                super.onUnhandledKeyEvent(view, event);
                LogUtils.dTag(TAG, "onUnhandledKeyEvent", view, event);
            }

            @Override
            public void onScaleChanged(WebView view, float oldScale, float newScale) {
                super.onScaleChanged(view, oldScale, newScale);
                LogUtils.dTag(TAG, "onScaleChanged", view, oldScale, newScale);
            }

            @Override
            public void onReceivedLoginRequest(WebView view, String realm, @Nullable String account, String args) {
                super.onReceivedLoginRequest(view, realm, account, args);
                LogUtils.dTag(TAG, "onReceivedLoginRequest", view, realm, account, args);
            }

            @Override
            public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
                LogUtils.dTag(TAG, "onRenderProcessGone", view, detail);
                return super.onRenderProcessGone(view, detail);
            }

            @Override
            public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
                super.onSafeBrowsingHit(view, request, threatType, callback);
                LogUtils.dTag(TAG, "onSafeBrowsingHit", view, request, threatType, callback);
            }
        });

//        mWebView.setWebViewClient(new WebViewClient());

//        mWebView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//                LogUtils.dTag(TAG, "onProgressChanged", view, newProgress);
//            }
//
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//                LogUtils.dTag(TAG, "onReceivedTitle", view, title);
//            }
//
//            @Override
//            public void onReceivedIcon(WebView view, Bitmap icon) {
//                super.onReceivedIcon(view, icon);
//                LogUtils.dTag(TAG, "onReceivedIcon", view, icon);
//            }
//
//            @Override
//            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
//                super.onReceivedTouchIconUrl(view, url, precomposed);
//                LogUtils.dTag(TAG, "onReceivedTouchIconUrl", view, url, precomposed);
//            }
//
//            @Override
//            public void onShowCustomView(View view, CustomViewCallback callback) {
//                super.onShowCustomView(view, callback);
//                LogUtils.dTag(TAG, "onShowCustomView", view, callback);
//            }
//
//            @Override
//            public void onHideCustomView() {
//                super.onHideCustomView();
//                LogUtils.dTag(TAG, "onHideCustomView");
//            }
//
//            @Override
//            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
//                LogUtils.dTag(TAG, "onCreateWindow", view, isDialog, isUserGesture, resultMsg);
//                return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
//            }
//
//            @Override
//            public void onRequestFocus(WebView view) {
//                super.onRequestFocus(view);
//                LogUtils.dTag(TAG, "onRequestFocus");
//            }
//
//            @Override
//            public void onCloseWindow(WebView window) {
//                super.onCloseWindow(window);
//                LogUtils.dTag(TAG, "onCloseWindow", window);
//            }
//
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                LogUtils.dTag(TAG, "onJsAlert", view, url, message, result);
//                return super.onJsAlert(view, url, message, result);
//            }
//
//            @Override
//            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
//                LogUtils.dTag(TAG, "onJsConfirm", view, url, message, result);
//                return super.onJsConfirm(view, url, message, result);
//            }
//
//            @Override
//            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
//                LogUtils.dTag(TAG, "onJsPrompt", view, url, message, defaultValue, result);
//                return super.onJsPrompt(view, url, message, defaultValue, result);
//            }
//
//            @Override
//            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
//                LogUtils.dTag(TAG, "onJsBeforeUnload", view, url, message, result);
//                return super.onJsBeforeUnload(view, url, message, result);
//            }
//
//            @Override
//            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
//                super.onGeolocationPermissionsShowPrompt(origin, callback);
//                LogUtils.dTag(TAG, "onGeolocationPermissionsShowPrompt", origin, callback);
//            }
//
//            @Override
//            public void onGeolocationPermissionsHidePrompt() {
//                super.onGeolocationPermissionsHidePrompt();
//                LogUtils.dTag(TAG, "onGeolocationPermissionsHidePrompt");
//            }
//
//            @Override
//            public void onPermissionRequest(PermissionRequest request) {
//                super.onPermissionRequest(request);
//                LogUtils.dTag(TAG, "onPermissionRequest", request);
//            }
//
//            @Override
//            public void onPermissionRequestCanceled(PermissionRequest request) {
//                super.onPermissionRequestCanceled(request);
//                LogUtils.dTag(TAG, "onPermissionRequestCanceled", request);
//            }
//
//            @Override
//            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
//                LogUtils.dTag(TAG, "onConsoleMessage", consoleMessage);
//                return super.onConsoleMessage(consoleMessage);
//            }
//
//            @Nullable
//            @Override
//            public Bitmap getDefaultVideoPoster() {
//                LogUtils.dTag(TAG, "getDefaultVideoPoster");
//                return super.getDefaultVideoPoster();
//            }
//
//            @Nullable
//            @Override
//            public View getVideoLoadingProgressView() {
//                LogUtils.dTag(TAG, "getVideoLoadingProgressView");
//                return super.getVideoLoadingProgressView();
//            }
//
//            @Override
//            public void getVisitedHistory(ValueCallback<String[]> callback) {
//                super.getVisitedHistory(callback);
//                LogUtils.dTag(TAG, "getVisitedHistory", callback);
//            }
//
//            @Override
//            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
//                LogUtils.dTag(TAG, "onShowFileChooser", webView, filePathCallback, fileChooserParams);
//                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
//            }
//        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}
