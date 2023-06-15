package com.vytautasdev.explicitintent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vytautasdev.explicitintent.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val myString = extras.getString("myString")
        binding.textView2.text = myString

        binding.button2.setOnClickListener {
            returnText(it)
        }
    }

    private fun returnText(view: View) {
        finish()
    }

    override fun finish() {
        val data = Intent()
        val returnString = binding.editText2.text.toString()
        data.putExtra("returnData", returnString)
        setResult(RESULT_OK, data)
        super.finish()
    }
}