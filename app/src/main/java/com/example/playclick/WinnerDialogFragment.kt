package com.example.playclick

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.playclick.databinding.FragmentPlayer1Binding
import com.example.playclick.databinding.FragmentWinnerDialogBinding


class WinnerDialogFragment : DialogFragment() {

    private var _binding: FragmentWinnerDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWinnerDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val winner = arguments?.getString("winner")
        binding.winnerText.text = "Winner: $winner"

        binding.restartButton.setOnClickListener {
            // Restart the game
            (activity as MainActivity).viewModel.resetCounters()
            dismiss()
        }

        binding.restartButton.setOnClickListener {
            // Restart the game
            (activity as MainActivity).viewModel.resetCounters()
            (activity as MainActivity).enablePlayerButtons() // Add this line
            dismiss()
        }
    }

    companion object {
        fun newInstance(winner: String): WinnerDialogFragment {
            val fragment = WinnerDialogFragment()
            val args = Bundle()
            args.putString("winner", winner)
            fragment.arguments = args
            return fragment
        }
    }
}