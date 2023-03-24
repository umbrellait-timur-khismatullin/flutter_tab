package com.example.fluttertab.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fluttertab.R
import com.example.fluttertab.databinding.FragmentDashboardBinding
import io.flutter.embedding.android.FlutterFragment

class DashboardFragment : Fragment() {

    companion object {
        private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment"
    }

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        parentFragmentManager
            .beginTransaction()
            .add(
                R.id.fragmentContainerView,
                FlutterFragment.withCachedEngine("my_engine_id").build<FlutterFragment>(),
                TAG_FLUTTER_FRAGMENT
            )
            .commit()
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}