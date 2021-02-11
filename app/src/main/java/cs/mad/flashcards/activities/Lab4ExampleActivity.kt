package cs.mad.flashcards.activities

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import cs.mad.flashcards.R
import cs.mad.flashcards.databinding.ActivityLab4ExampleBinding

class Lab4ExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLab4ExampleBinding
    private var clickedNum = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLab4ExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnLongClickListener {
            Snackbar.make(binding.root, "Long click success!", Snackbar.LENGTH_LONG).show()
            true
        }

        binding.button.setOnClickListener {
            // show standard dialog
            showStandardDialog()
        }

        binding.button2.setOnClickListener {
            // show custom dialog
            showCustomDialog()
        }

        binding.button3.setOnClickListener {
            // update view on click
            clickedNum++
            binding.textView.text = "Long Click $clickedNum"
        }

        binding.button4.setOnClickListener {
            // end activity
            finish()
        }
    }

    private fun showStandardDialog() {
        AlertDialog.Builder(this)
            .setTitle("My title")
            .setMessage("My message")
            .setPositiveButton("EZ") { dialogInterface: DialogInterface, i: Int ->
                // do something on click
            }
            .create()
            .show()
    }

    private fun showCustomDialog() {
        val titleView = layoutInflater.inflate(R.layout.custom_title, null)
        val bodyView = layoutInflater.inflate(R.layout.custom_body, null)
        val titleEditText = titleView.findViewById<EditText>(R.id.custom_title)
        val bodyEditText = bodyView.findViewById<EditText>(R.id.custom_body)
        titleEditText.setText("Starting title")
        bodyEditText.setText("Starting body")

        AlertDialog.Builder(this)
            .setCustomTitle(titleView)
            .setView(bodyView)
            .setPositiveButton("EZ") { dialogInterface: DialogInterface, i: Int ->
                // do something on click
                Snackbar.make(binding.root, titleEditText.text.toString(), Snackbar.LENGTH_LONG).show()
            }
            .create()
            .show()
    }
}