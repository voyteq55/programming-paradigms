var count = 0
while count < 3 do
    println(count)
    count += 1

def whileLoop(condition: => Boolean, expression: => Unit): Unit =
    if condition then {
        expression
        whileLoop(condition, expression)
    }

count = 0
whileLoop(count < 3, {
    println(count)
    count += 1
})

def swap[T](xss: Array[T], i: Int, j: Int): Unit =
    val temp = xss(i)
    xss(i) = xss(j)
    xss(j) = temp

def choosePivot(xss: Array[Int], start: Int, end: Int): Int =
    xss((start + end) / 2)

def partition(xss: Array[Int], start: Int, end: Int): (Int, Int) =
    val pivot = choosePivot(xss, start, end)
    var i = start
    var j = end
    while i <= j do
        while xss(i) < pivot do
            i = i + 1
        while pivot < xss(j) do
            j = j - 1
        if i <= j then
            swap(xss, i, j)
            i = i + 1
            j = j - 1
    (i, j)

def quick(xss: Array[Int], l: Int, r: Int): Unit =
    if l < r then
        val (i, j) = partition(xss, l ,r)
        quick(xss, l, j)
        quick(xss, i, r)
        
def quicksort(xss: Array[Int]): Unit =
    quick(xss, 0, xss.length - 1)

var numArray = Array(5, 12, 44, 12, 0, -1, 32, 4, 23, 44, 1, 5, 89, 0, 111, 2)
quicksort(numArray)
for (i <- numArray) println(i)
