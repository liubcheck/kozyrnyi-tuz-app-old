package tuztech.kozyrnyituzapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import tuztech.kozyrnyituzapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set up RecyclerView
        binding.barbershopRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            // The adapter will be set when the data is loaded
        }

        // Observe the barbershop LiveData from the ViewModel
        homeViewModel.barbershops.observe(viewLifecycleOwner) { barbershops ->
            binding.barbershopRecyclerView.adapter = BarbershopAdapter(barbershops)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
