package com.example.problemsolving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private val TAG = "google"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = arrayOf(3, 10, 2, 9)
        bonAppetit(test, 1, 12)
    }

    fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
        // Write your code here
        val annaBill = bill
        annaBill.toMutableList().removeAt(k)
        val annMoney = annaBill.sum() / 2
        if (annMoney == b) {
            println("Bon Appetit")
        } else {
            println(b-annMoney)
        }

    }

    fun breakingRecords(scores: Array<Int>): Array<Int> {
        // Write your code here
        var minScore = scores.first()
        var maxScore = scores.first()
        var minScoreCount = 0
        var maxScoreCount = 0
        scores.forEach { score ->
            when {
                score > maxScore -> {
                    Log.d(TAG, "current $score >  $maxScore")
                    maxScore = score
                    maxScoreCount += 1
                }
                score < minScore -> {
                    minScore = score
                    minScoreCount += 1
                }
            }

        }
        Log.d(TAG, "hack" + listOf(minScoreCount, maxScoreCount).toString())
        return arrayOf(maxScoreCount, minScoreCount)
    }

    fun miniMaxSum(arr: Array<Int>): Unit {
        val sortedList = arr.sorted()
        val min = sortedList.take(4).sumOf { it.toLong() }
        val max = sortedList.takeLast(4).sumOf { it.toLong() }
        Log.d(TAG, "$min $max")
        println("$min  $max")
    }

    fun birthdayCakeCandles(candles: Array<Int>): Int {
        var tallestCandle: Int = 0
        candles.forEach { candle ->
            if (candle > tallestCandle) {
                tallestCandle = candle
            }

        }
        return candles.filter { it == tallestCandle }.size

    }

    fun staircase(n: Int): Unit {
        for (i in 1..n) {
            val space = StringBuilder()
            val stair = StringBuilder()
            space.append(" ".repeat(n - i))
            stair.append("#".repeat(i))
            println(space.toString() + stair)
        }
    }


    fun diagonalDifference(arr: List<List<Int>>): Int {
        // Write your code here
        val leftMatrix = mutableListOf<Int>()
        val rightMatrix = mutableListOf<Int>()
        for (index in arr.indices) {
            val rowNum = arr.size - 1
            rightMatrix.add(arr[index][index])
            leftMatrix.add(arr[index][rowNum - index])
        }
        Log.d(TAG, "left $leftMatrix")
        Log.d(TAG, "right $rightMatrix")
        val differentSum = abs(leftMatrix.sum() - rightMatrix.sum())
        return differentSum

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