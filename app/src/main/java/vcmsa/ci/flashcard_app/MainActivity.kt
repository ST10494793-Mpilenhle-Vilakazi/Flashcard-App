package vcmsa.ci.flashcard_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startQuizButton)
        startButton.setOnClickListener {
           val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
       }
    }
}