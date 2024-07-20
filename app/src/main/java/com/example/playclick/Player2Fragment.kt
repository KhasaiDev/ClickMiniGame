package com.example.playclick

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.playclick.databinding.FragmentPlayer2Binding

class Player2Fragment : Fragment() {

    private var _binding: FragmentPlayer2Binding? = null
    private val binding get() = _binding!!
    private val viewModel: CounterViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayer2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            counterText.text = viewModel.counter2.value.toString()
            clickButton2.setOnClickListener {
                viewModel.incrementCounter2()
                viewModel.decrementCounter1()
            }
        }

        viewModel.counter2.observe(viewLifecycleOwner) {
            binding.counterText.text = it.toString()
        }
    }

    fun disableButton() {
        binding.clickButton2.isEnabled = false
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}