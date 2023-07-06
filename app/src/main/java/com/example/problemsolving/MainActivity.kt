package com.example.problemsolving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "google"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = intArrayOf(7, 1, 5, 3, 6, 4)
        val target = 5

        maxProfit(list)


    }

    fun maxProfit(prices: IntArray): Int? {
        val profitList = mutableListOf<Int>()
        //sell as the key profit as the value
        var startIndex = 0
        // we will add on this map the num
        prices.forEachIndexed { buyIndex, buyValue ->

            prices.forEachIndexed { sellIndex, sellValue ->
                while (startIndex < sellIndex) {
                    Log.d(TAG, "buy is $buyValue  sell is $sellValue")
                    val profit = buyValue - sellValue
                    profitList.add(profit)

                    startIndex++
                }


            }

        }
       Log.d(TAG, "profit list is $profitList  max profit ")
        return profitList.maxOrNull()

    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        // first would be value, second is the index
        for (i in nums.indices) {
            // we do for loop for all items in the list
            val complementaryNumber = target - nums[i]
            // looking for complementary number which is the subtract of target and current number in the lop
            if (map.containsKey(complementaryNumber)) {
                // if the complementary number ( the number we are looking for) is already added to the map  then we need to add the current number in the loop which will give us the target
                // then we need to return the indices of the number on the map and we can get this by passing value of the complementary number as we are already saving on the map the value and the indices
                // and also the index of the current number on the loop  which complete the target

                return intArrayOf(map[complementaryNumber]!!, i)
            }


            map[nums[i]] = i
        }
        return intArrayOf()
    }


}