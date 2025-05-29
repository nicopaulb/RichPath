package com.richpathanimator.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.richpath.RichPath
import com.richpathanimator.sample.databinding.ActivityCompoundViewSamplesBinding

class CompoundViewSamplesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCompoundViewSamplesBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompoundViewSamplesBinding.inflate(layoutInflater);
        setContentView(R.layout.activity_compound_view_samples)

        val bluePath = binding.colorPickerRichPathView.findRichPathByName("bluePath")
        val redPath = binding.colorPickerRichPathView.findRichPathByName("redPath")
        val greenPath = binding.colorPickerRichPathView.findRichPathByName("greenPath")
        val purplePath = binding.colorPickerRichPathView.findRichPathByName("purplePath")

        binding.colorPickerRichPathView.onPathClickListener = object : RichPath.OnPathClickListener {
            override fun onClick(richPath: RichPath) {
                bluePath?.strokeAlpha = 0f
                redPath?.strokeAlpha = 0f
                greenPath?.strokeAlpha = 0f
                purplePath?.strokeAlpha = 0f

                if (richPath == bluePath
                        || richPath == redPath
                        || richPath == greenPath
                        || richPath == purplePath) {
                    richPath.strokeAlpha = 0.5f
                    richPath.name?.let { showToast(it) }
                }
            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}