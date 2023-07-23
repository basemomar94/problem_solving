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

        val test = arrayOf(73, 67, 38, 33)
        Log.d(TAG, migratoryBirds(arrayOf(1 ,2, 3, 4, 5, 4, 3, 2, 1, 3, 4)).toString())

    }

    fun migratoryBirds1(arr: Array<Int>): Int {
        // Write your code here
        val repetitionList = mutableListOf<Int>()
        var highestRep = 0
        arr.forEach { bird ->
            val birdRepetition = arr.filter { it == bird }.size
            if (birdRepetition > highestRep) {
                highestRep = birdRepetition
                repetitionList.clear()
                repetitionList.add(bird)
            } else if (birdRepetition == highestRep) {
                repetitionList.add(bird)
            }

        }
        return repetitionList.sorted().first()

    }
    fun migratoryBirds(arr: Array<Int>): Int {
        // Write your code here
        val repetitionList = mutableListOf<Int>()
        var highestRep = 0
        arr.forEach { bird ->
            val birdRepetition = arr.filter { it == bird }.size
            if (birdRepetition > highestRep) {
                highestRep = birdRepetition
                repetitionList.clear()
                repetitionList.add(bird)
            } else if (birdRepetition == highestRep) {
                repetitionList.add(bird)
            }

        }
        return repetitionList.sorted().first()

    }



    fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
        // Write your code here
        var correctNumber = 0
        val suspectedRange = a.last()..b.first()
        for (num in suspectedRange) {
            var numTest = 0

            a.forEach { _a ->
                if (num % _a != 0) {
                    return@forEach
                }
                numTest += 1
            }

            b.forEach { _b ->
                if (_b % num != 0) {
                    return@forEach
                }
                numTest += 1
            }

            if (numTest == a.size + b.size) {
                correctNumber += 1
                numTest = 0
            }

        }
        return correctNumber

    }

    fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
        if (v1 * v2 < 0 && x2 - x1 > v1 - v2) {
            return "NO"
        }
        // Write your code here
        var distanceOne = x1
        var distanceTwo = x2
        for (j in 0..10000
        ) {
            distanceOne += v1
            distanceTwo += v2
            Log.d(TAG, "$distanceOne  $distanceTwo")
            if (distanceOne == distanceTwo) {
                return "YES"
            }

        }
        return "NO"

    }

    fun utopianTree(n: Int): Int {
        // Write your code here
        var treeHeight = 1
        for (cycle in 1..n) {
            if (cycle % 2 != 0) {
                treeHeight *= 2
            } else {
                treeHeight += 1
            }
        }
        return treeHeight

    }

    fun beautifulDays(i: Int, j: Int, k: Int): Int {
        // Write your code here
        var beautifulCount = 0
        for (num in i..j) {
            val numRev = num.toString().reversed().toInt()
            //  Log.d(TAG, "${num / k}  ${numRev / k}")
            if ((num - numRev) % k == 0) {
                beautifulCount += 1
            }

        }
        return beautifulCount

    }

    fun solve(meal_cost: Double, tip_percent: Int, tax_percent: Int): Unit {
        val tipCoast = ((tip_percent / 100) * meal_cost)
        Log.d(TAG, "tip ${tip_percent / 100}")
        val taxCoast = ((tax_percent.toDouble() / 100) * meal_cost)
        val total = tipCoast + meal_cost + taxCoast
        Log.d(TAG, "$tipCoast  $taxCoast ${total.toInt()}")
        println(Math.round(total))

    }

    fun countingValleys(steps: Int, path: String): Int {
        // Write your code here
        var valleyCount = 0
        var aboveSeaSteps = 0
        val elevationsList = mutableListOf<Int>()
        val pathList = path.toList()
        pathList.forEach { path ->
            if (path == 'U') {
                aboveSeaSteps += 1
            } else {
                aboveSeaSteps -= 1
            }
            elevationsList.add(aboveSeaSteps)

        }
        Log.d(TAG, "$elevationsList")
        var lastElevation = 0
        elevationsList.forEach { elevation ->
            Log.d(TAG, "last $lastElevation current $elevation")
            if (lastElevation < 0 && elevation >= 0) {
                valleyCount += 1
            }
            lastElevation = elevation
        }

        return valleyCount

    }

    fun timeConversion(s: String): String {
        val indicator = s.toList().reversed()[1]
        val isPm = indicator == 'P'
        Log.d(TAG, "indicator is $indicator $isPm")
        val timeWithoutLast2 = s.dropLast(2)
        Log.d(TAG, "time without $timeWithoutLast2")
        val hour = "${timeWithoutLast2[0]}${timeWithoutLast2[1]}"
        val timeWithoutHour = timeWithoutLast2.drop(2)
        Log.d(TAG, "hour is $hour")
        return if (isPm) {
            val militaryHour = if (hour.toInt() != 12) hour.toInt() + 12 else hour.toInt()
            "$militaryHour$timeWithoutHour"
        } else {
            if (hour == "12") {
                "00$timeWithoutHour"
            } else {
                timeWithoutLast2
            }

        }

    }

    fun countApplesAndOranges(
        s: Int,
        t: Int,
        a: Int,
        b: Int,
        apples: Array<Int>,
        oranges: Array<Int>,
    ): Unit {
        // Write your code here
        val houseRange = s..t
        var appleCount = 0
        var orangeCount = 0
        apples.forEach { apple ->
            if ((apple + a) in houseRange) {
                appleCount++
            }

        }
        println(appleCount)
        oranges.forEach { orange ->
            if ((orange + b) in houseRange) {
                orangeCount++
            }
        }
        println(orangeCount)
        Log.d(TAG, "$appleCount  $orangeCount")

    }

    fun gradingStudents(grades: Array<Int>): Array<Int> {
        // Write your code here
        val finalGrades = mutableListOf<Int>()
        grades.forEach { grade ->

            if (grade > 37) {
                val different = 5 - (grade % 5)
                val nextRound = grade + different
                if (different < 3) {
                    finalGrades.add(nextRound)
                } else {
                    finalGrades.add(grade)
                }
                Log.d(TAG, "diff $different  $grade  $nextRound")

            } else {
                Log.d(TAG, "student failed $grade")
                finalGrades.add(grade)
            }

            Log.d(TAG, "grade is $grade  list $finalGrades")

        }

        return finalGrades.toTypedArray()
    }

    fun superReducedString(s: String): String {
        val sequence = s.toMutableList()
        // Write your code here
        for (i in sequence.indices) {
            try {
                val firstChar = s[i]
                val secondChar = s[i + 1]
                Log.d(TAG, "$firstChar == $secondChar")
                if (firstChar == secondChar) {
                    sequence.remove(firstChar)
                    sequence.remove(secondChar)
                    Log.d(TAG, sequence.toString())
                }
            } catch (e: java.lang.Exception) {

            }
            //   Log.d(TAG,"first $firstChar $i")

        }
        return sequence.joinToString("")
    }

    fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
        // Write your code here
        var count = 0
        for (i in ar.indices) {
            for (j in i + 1 until ar.size) {
                val pairOne = ar[i]
                val pairTwo = ar[j]
                Log.d(TAG, "$pairOne   $pairTwo  ")
                if ((pairOne + pairTwo) % k == 0) {
                    val test = readLine()
                    count++
                    Log.d(TAG, "count is $count")
                }
            }
        }
        return count
    }

    fun hurdleRace(k: Int, height: Array<Int>): Int {
        // Write your code here
        var highestHurdle = 0
        height.forEach { _heiht ->
            if (_heiht > highestHurdle) {
                highestHurdle = _heiht
            }

        }
        val requiredBills = highestHurdle - k
        return if (requiredBills > 0) requiredBills else 0

    }

    fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
        // Write your code here
        val annaBill = bill.toMutableList()
        annaBill.removeAt(k)
        Log.d(TAG, "ann list ${annaBill.map { it }}")
        val annMoney = annaBill.sum() / 2
        Log.d(TAG, "ann share $annMoney")
        if (annMoney == b) {
            println("Bon Appetit")
        } else {
            println(b - annMoney)
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