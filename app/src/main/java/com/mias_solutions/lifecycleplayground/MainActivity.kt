package com.mias_solutions.lifecycleplayground

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mias_solutions.lifecycleplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val lifecycleTag = "MainActivity"

    private var counter = 0

    companion object {
        private const val KEY_COUNTER = "key_counter"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_COUNTER, 0)
            binding.counterTv.text = "$counter"
        }

        binding.counterTv.text = "$counter"

        binding.counterBtn.setOnClickListener {
            counter++
            binding.counterTv.text = "$counter"
        }


        logLifecycle("onCreate")

        binding.btnNavigate.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter)
    }



    override fun onStart() {
        super.onStart()
        logLifecycle("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycle("onRestart")
    }

    override fun onPause() {
        super.onPause()
        logLifecycle("onPause")
    }

    override fun onResume() {
        super.onResume()
        logLifecycle("onResume")
    }

    override fun onStop() {
        super.onStop()
        logLifecycle("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle("onDestroy")
    }

    private fun logLifecycle(method: String) {
        val message = "$lifecycleTag : $method"
        Log.d(lifecycleTag, message)
        binding.tvLifecycleLogs.append("$message\n")
        binding.tvLifecycleLogs.movementMethod = ScrollingMovementMethod()

    }
}