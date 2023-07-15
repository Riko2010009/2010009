package com.example.riko2010009.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.riko2010009.LoginActivity
import com.example.riko2010009.R
import com.example.riko2010009.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        dashboardViewModel.text.observe(viewLifecycleOwner) {

        }

        val orangImageView = view.findViewById<ImageView>(R.id.orang)
        orangImageView.setOnClickListener {
            openLoginActivity()
        }
    }

    private fun openLoginActivity() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        /* Menggantikan fragment saat tombol profil ditekan
        val profileFragment = ProfileFragment() // Ganti dengan fragment profil yang sesuai
        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, profileFragment)
        transaction.addToBackStack(null)
        transaction.commit()
        */
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}