package com.example.playclick

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.playclick.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    public val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer1, Player1Fragment())
            .replace(R.id.fragmentContainer2, Player2Fragment())
            .commit()

        viewModel.winner.observe(this) { winner ->
            if (winner != null) {
                showWinnerScreen(winner)
            }
        }
    }

    private fun showWinnerScreen(winner: String) {
        val winnerDialogFragment = WinnerDialogFragment.newInstance(winner)
        winnerDialogFragment.show(supportFragmentManager, "winner_dialog")
        // Disable the click buttons in both fragments
        val player1Fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer1) as Player1Fragment
        val player2Fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer2) as Player2Fragment
        player1Fragment.disableButton()
        player2Fragment.disableButton()
    }

    public fun enablePlayerButtons() {
        // Get references to the player buttons
        val player1Button = findViewById<Button>(R.id.clickButton)
        val player2Button = findViewById<Button>(R.id.clickButton2)

        // Enable the buttons
        player1Button.isEnabled = true
        player2Button.isEnabled = true
    }
}

