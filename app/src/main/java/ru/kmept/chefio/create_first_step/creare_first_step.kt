package ru.kmept.chefio

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.EditText

class creare_first_step : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_create_first_step)

        val seekBar: SeekBar = findViewById(R.id.seekBar2)
        val valueTextView: TextView = findViewById(R.id.textView8)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("КМЕПТ", progress.toString())
                valueTextView.setText(progress.toString())
                if (progress == 0) {
                    valueTextView.setTextColor(Color.parseColor("#9FA5C0"))
                } else {
                    valueTextView.setTextColor(Color.parseColor("#1FCC79"))
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }
        })
    }

    public fun onclicktosecond(view: View)
    {
        val seekbar: SeekBar = findViewById(R.id.seekBar2)
        val progress = seekbar.progress
        val name = findViewById<EditText>(R.id.food_name).text.toString()
        val description = findViewById<EditText>(R.id.food_description).text.toString()
        // Create the Intent
        var sec = Intent(this, newscreen::class.java)

        // Add the name and description as extras
        sec.putExtra("name", name)
        sec.putExtra("description", description)
        sec.putExtra("progress", progress)



        // Start the second screen
        startActivity(sec)
    }

            public fun onclicktomain(view: View) {
                var sec = Intent(this, MainActivity::class.java)
                startActivity(sec);
            }
        }
