package com.example.mora_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isNotEmpty
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btnSet()
    }

    private fun btnSet() {
        button_mora.setOnClickListener {
            if (editText_name.text.isNotEmpty() && radioGroup.isNotEmpty()) {

                // Show player name
                textView_showName.text = "玩家姓名 : ${editText_name.text}"

                // Show your choose
                when {
                    radioButton_scissor.isChecked -> textView_gamer_result.text = "玩家出剪刀"
                    radioButton_rock.isChecked -> textView_gamer_result.text = "玩家出石頭"
                    radioButton_paper.isChecked -> textView_gamer_result.text = "玩家出布"
                }

                // Generate computer choose
                val computer: Int = (1..3).shuffled().first()
                when (computer) {
                    1 -> textView_computer_result.text == "電腦出剪刀"
                    2 -> textView_computer_result.text == "電腦出石頭"
                    3 -> textView_computer_result.text == "電腦出布"
                }

                when {
                    // Win
                    computer == 1 && radioButton_rock.isChecked ||
                    computer == 2 && radioButton_paper.isChecked ||
                    computer == 3 && radioButton_scissor.isChecked -> textView_winner.text = "恭喜${editText_name.text}獲勝"

                    // Lose
                    computer == 1 && radioButton_paper.isChecked ||
                    computer == 2 && radioButton_scissor.isChecked ||
                    computer == 3 && radioButton_rock.isChecked -> textView_winner.text = "可惜，電腦獲勝"

                    // Draw
                    computer == 1 && radioButton_scissor.isChecked ||
                    computer == 2 && radioButton_rock.isChecked ||
                    computer == 3 && radioButton_paper.isChecked -> textView_winner.text = "平手，請再試一次"
                }
            } else {
                Toast.makeText(this, "No no no, you can't do that.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
