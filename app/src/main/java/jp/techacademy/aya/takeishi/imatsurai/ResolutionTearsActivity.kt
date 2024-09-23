package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResolutionTearsActivity : AppCompatActivity() {

    // WebViewに表示するURL
    private val tearsUrl = "https://www.tearsteacher.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resolution_tears)

        // WebViewの設定
        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient() // 外部ブラウザではなくWebView内で表示
        webView.settings.javaScriptEnabled = true // 必要に応じてJavaScriptを有効に

        // TextViewのクリックリスナーを設定
        val textView = findViewById<TextView>(R.id.textView)
        textView.setOnClickListener {
            loadWebView(webView)
        }

        // リンクTextViewのクリックリスナーを設定
        val linkTextView = findViewById<TextView>(R.id.linkTextView)
        linkTextView.setOnClickListener {
            loadWebView(webView)
        }

        // 「メニュー選択画面に戻る」ボタンのクリックリスナーを設定
        val returnButton = findViewById<Button>(R.id.returnButton)
        returnButton.setOnClickListener {
            // MenuSelectActivityへ遷移
            val intent = Intent(this, MenuSelectActivity::class.java)
            startActivity(intent)
        }
    }

    // WebViewをロードして表示する関数
    private fun loadWebView(webView: WebView) {
        // URLをロードし、WebViewを表示する
        webView.loadUrl(tearsUrl)
        webView.visibility = WebView.VISIBLE

        // textViewとlinkTextViewを非表示にする
        findViewById<TextView>(R.id.textView).visibility = TextView.GONE
        findViewById<TextView>(R.id.linkTextView).visibility = TextView.GONE
    }
}