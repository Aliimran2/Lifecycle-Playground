package com.mias_solutions.lifecycleplayground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mias_solutions.lifecycleplayground.databinding.ActivityMainBinding
import com.mias_solutions.lifecycleplayground.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private val secondActivityTag = "SecondActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //for back button on action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        logLifeCycle("onCreate")

        binding.btnNavigateSecond.text = "Go back to Main Activity"
        binding.btnNavigateSecond.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //this line below ensure the MainActivity will not recreate
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        logLifeCycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifeCycle("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifeCycle("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifeCycle("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        logLifeCycle("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycle("onDestroy")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                //this line below ensure the MainActivity will not recreate
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun logLifeCycle(method: String) {
        val message = "$secondActivityTag: $method"
        Log.d(secondActivityTag, message)
        binding.tvLifecycleLogsSecond.append("$message\n")
    }
}