def primes(n: Int) =
    val numbers = List.range(2, n + 1)
    def isPrime(num: Int) =
        var isPrimeResult = true
        val possibleDivisors = List.range(2, math.sqrt(num).toInt + 1)
        for (divisor <- possibleDivisors) {
            if (num % divisor == 0) isPrimeResult = false
        }
        isPrimeResult
    for (
        k <- numbers;
        if isPrime(k)
    ) yield k

primes(0)
primes(1)
primes(2)
primes(10)
primes(121)
