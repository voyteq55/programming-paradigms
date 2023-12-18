let imperacci m n =
    let
      skiponacciSequence = Array.make n 0 and
      previousValue = ref 0 and
      currentValue = ref 1 and
      index = ref 0 and
      skiponacciDegree = ref (2 * (m - 1))
    in if m < 1 then
      skiponacciDegree := 0;
    while !index < n do
      if !skiponacciDegree = 0 then (
        skiponacciSequence.(!index) <- !currentValue;
        index := !index + 1
      ) else
        skiponacciDegree := !skiponacciDegree - 1;
      currentValue := !previousValue + !currentValue;
      previousValue := !currentValue - !previousValue
    done;
    skiponacciSequence

let testImperacci1 = imperacci 1 10
let testImperacci2 = imperacci 2 6
let testImperacci3 = imperacci 4 10
let testImperacci4 = imperacci 2 0
let testImperacci5 = imperacci 0 6

let composites n =
  let
    isPrime = Array.make (n + 1) true and
    index = ref 2
  in
    while !index * !index <= n do
      if isPrime.(!index) then 
        let multiple = ref (2 * !index) in
        while !multiple <= n do
          isPrime.(!multiple) <- false;
          multiple := !multiple + !index
        done;
      ;
      index := !index + 1
    done;
    index := 0;
    let numberOfComposites = ref 0 in
    while !index <= n do
      if not isPrime.(!index) then
        numberOfComposites := !numberOfComposites + 1;
      index := !index + 1
    done;
    index := 0;
    let compositeNumbers = Array.make !numberOfComposites 0 and
    compositesIndex = ref 0
    in
    while (!index <= n) do
      if not isPrime.(!index) then (
        compositeNumbers.(!compositesIndex) <- !index;
        compositesIndex := !compositesIndex + 1
      );
      index := !index + 1
    done;
    compositeNumbers

let testComposite1 = composites 0
let testComposite2 = composites 121
