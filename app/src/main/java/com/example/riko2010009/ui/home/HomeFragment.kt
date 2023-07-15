package com.example.riko2010009.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.riko2010009.adapter.AdapterBarang
import com.example.riko2010009.app.ApiConfig
import com.example.riko2010009.R
import com.example.riko2010009.model.BarangModel
import com.example.riko2010009.model.ResponseModel
import retrofit2.Response

class HomeFragment : Fragment() {

    //
    lateinit var rvBarang: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getBarang()
        return view
    }

    private var listBarang: ArrayList<BarangModel> = ArrayList()

    fun getBarang(){
        ApiConfig.instanceRetrofit.getBarang().enqueue(object :
            retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: retrofit2.Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                listBarang = res.barang
                displayBarang()
            }
            override fun onFailure(call: retrofit2.Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun displayBarang() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvBarang.layoutManager = layoutManager
        rvBarang.adapter = AdapterBarang(requireActivity(), listBarang)
    }


    fun init(view: View) {
        //rvBarang = view.findViewById(R.id.recyler_view)
        rvBarang=view.findViewById(R.id.recyler_view)
    }

}