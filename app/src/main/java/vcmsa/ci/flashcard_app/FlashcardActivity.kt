package vcmsa.ci.flashcard_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {
    private var score = 0
    private var currentQuestion = 0

    //Sample Questions and answers
    private val questions = listOf(
        "The Earth is flat.",
        "The moon is a planet.",
        "The sun is smaller than the Earth.",
        "Jupiter has 27 moons.",
    )
     private val answers = listOf(
         false,
         true,
         false
     )

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

    val questionText = findViewById<TextView>(R.id.questionTextView)
    val trueButton = findViewById<Button>(R.id.trueButton)
    val falseButton = findViewById<Button>(R.id.falseButton)
    val feedbackText = findViewById<TextView>(R.id.feedbackTextView)
    val nextButton = findViewById<Button>(R.id.nextButton)

    // SHow first question
questionText.text = questions[currentQuestion]

    trueButton.setOnClickListener {
        Log.d("FlashcardActivity", "True button clicked")
        checkAnswer(true, feedbackText, trueButton, falseButton)
    }
    falseButton.setOnClickListener {
        Log.d("FlashcardActivity", "False button clicked")
        checkAnswer(false, feedbackText, trueButton, falseButton)
    }
    nextButton.setOnClickListener {
        Log.d("FlashcardActivity", "Next button clicked")
        currentQuestion++

        if(currentQuestion < questions.size) {

            //Next question
            questionText.text = questions[currentQuestion]
            feedbackText.text = ""
            trueButton.isEnabled = true
            falseButton.isEnabled = true

            //Quiz complete go to ScoreActivity
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("TOTAL", questions.size)
            startActivity(intent)
            Log.d("FlashcardActivity", "Moving to ScoreActivity with score:$score")
            finish()

        }
    }
}
@SuppressLint("SetTextI18n")
private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView, trueButton: Button, falseButton: Button) {
    if (userAnswer == answers[currentQuestion]) {
        score++
    } else {
        feedbackText.text = "Wrong!"
    }
    trueButton.isEnabled = false
    falseButton.isEnabled = false
    }
}