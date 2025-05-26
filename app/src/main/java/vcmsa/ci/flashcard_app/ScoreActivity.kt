package vcmsa.ci.flashcard_app

import android.annotation.SuppressLint
import vcmsa.ci.flashcard_app.R.id.scoreTextView
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 0)

        val scoreText = findViewById<TextView>(R.id.scoreTextView)
        scoreText.text = "You scored $score out of $total"
    }
}