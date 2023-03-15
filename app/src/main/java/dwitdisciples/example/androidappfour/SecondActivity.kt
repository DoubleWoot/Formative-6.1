package dwitdisciples.example.androidappfour

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg = intent.getStringExtra("MESSAGE")

        val textView = findViewById<TextView>(R.id.textView1).apply{
            text = msg
        }
        val intent = intent
    }

    fun doBack(v: View?) {
        finish()
    }
}
