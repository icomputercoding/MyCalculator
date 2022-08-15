package `in`.icomputercoding.mycalculator

import `in`.icomputercoding.mycalculator.databinding.ActivityMainBinding
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnClear.setOnClickListener {
            binding.Input.text = ""
            binding.result.text = ""
        }

        binding.BtnZero.setOnClickListener {
            evaluateExpression("0", true)
        }

        binding.BtnZero2.setOnClickListener {
            evaluateExpression("00", true)
        }

        binding.BtnOne.setOnClickListener {
            evaluateExpression("1", true)
        }

        binding.BtnTwo.setOnClickListener {
            evaluateExpression("2", true)
        }

        binding.BtnThree.setOnClickListener {
            evaluateExpression("3", true)
        }

        binding.BtnFour.setOnClickListener {
            evaluateExpression("4", true)
        }

        binding.BtnFive.setOnClickListener {
            evaluateExpression("5", true)
        }

        binding.BtnSix.setOnClickListener {
            evaluateExpression("6", true)
        }

        binding.BtnSeven.setOnClickListener {
            evaluateExpression("7", true)
        }

        binding.BtnEight.setOnClickListener {
            evaluateExpression("8", true)
        }

        binding.BtnNine.setOnClickListener {
            evaluateExpression("9", true)
        }


        binding.BtnDot.setOnClickListener {
            evaluateExpression(".", true)
        }

        binding.BtnPlus.setOnClickListener {
            evaluateExpression("+", false)
        }

        binding.BtnMinus.setOnClickListener {
            evaluateExpression("-", false)
        }

        binding.BtnMultiply.setOnClickListener {
            evaluateExpression("*", false)
        }

        binding.BtnDivide.setOnClickListener {
            evaluateExpression("/", false)
        }

        binding.BtnAns.setOnClickListener {

            try {
                val expression = ExpressionBuilder(binding.Input.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.result.text = longResult.toString()
                } else
                    binding.result.text = result.toString()

            } catch (e: Exception) {
                Toast.makeText(this,"Invalid Operation",Toast.LENGTH_SHORT).show()
            }
        }


    }


    private fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            binding.result.text = ""
            binding.Input.append(string)
        } else {
            binding.Input.append(binding.result.text)
            binding.Input.append(string)
            binding.result.text = ""
        }
    }

}