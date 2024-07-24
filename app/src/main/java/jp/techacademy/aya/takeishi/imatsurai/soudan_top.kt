package jp.techacademy.aya.takeishi.imatsurai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import java.util.*

class soudan_top : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soudan_top)

        // DatePicker の初期化
        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        // 現在の日付を設定する
        val calendar = Calendar.getInstance()
        datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ) { view, year, monthOfYear, dayOfMonth ->
            // 日付が選択された時の処理
            // 必要ならここにコードを追加
        }

        // 次へボタンのクリックリスナーを設定
        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            // soudan_naiyou 画面に遷移する
            val intent = Intent(this, soudan_naiyou::class.java)
            startActivity(intent)
        }
    }
}