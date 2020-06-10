package com.mobilefit.ui.stopper

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mobilefit.R
import kotlinx.android.synthetic.main.fragment_stopper.*

class StopperFragment : Fragment() {

	private lateinit var stopperViewModel: StopperViewModel
	private var maxTimeStopperSec: Long = 60000
	private lateinit var timer: CountDownTimer
	private var time: Long = 0
	private var timestamp: Long = 0

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		stopperViewModel =
			ViewModelProviders.of(this).get(StopperViewModel::class.java)
		val root = inflater.inflate(R.layout.fragment_stopper, container, false)
		return root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		stopperstart_button.setText("Start")
		stopperreset_button.setText("Reset")

		setText(time)

		stopperstart_button.setOnClickListener {
			if (stopperstart_button.text == "Start") {
				stopperstart_button.setText("Stop")
				timestamp = System.currentTimeMillis()


				timer = object : CountDownTimer(maxTimeStopperSec * 1000, 1) {
					override fun onFinish() {

					}

					override fun onTick(millisUntilFinished: Long) {
						var tmp = System.currentTimeMillis()
						time += tmp - timestamp
						timestamp = tmp
						if (stoper_display != null) {
							setText(time)
						}

					}
				}.start()
			} else {
				timer.cancel()
				stopperstart_button.setText("Start")
			}
		}

		stopperreset_button.setOnClickListener {
			if (stopperstart_button.text == "Stop") {
				timer.cancel()
				stopperstart_button.setText("Start")
			}
			time = 0
			setText(time)
		}
	}

	fun setText(time: Long) {
		val millis = (time % 1000).toInt()
		val seconds = ((time / 1000) % 60).toInt()
		val minutes = ((time / (1000 * 60)) % 60).toInt()
		val hours = (time / (1000 * 60 * 60)).toInt()
		val textToDisplay = "$hours:$minutes:$seconds:$millis"
		stoper_display.setText(textToDisplay)
	}

}