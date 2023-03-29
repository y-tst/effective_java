# Benchmark for  Binary Search - Recursive and Iterative:

C:\Users\Yurii_Yanchuk\.jdks\corretto-16.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.1\lib\idea_rt.jar=55562:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Learning\JavaMentoring2023\effective_java\target\classes;C:\Users\Yurii_Yanchuk\.m2\repository\com\google\guava\guava\31.1-jre\guava-31.1-jre.jar;C:\Users\Yurii_Yanchuk\.m2\repository\com\google\guava\failureaccess\1.0.1\failureaccess-1.0.1.jar;C:\Users\Yurii_Yanchuk\.m2\repository\com\google\guava\listenablefuture\9999.0-empty-to-avoid-conflict-with-guava\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;C:\Users\Yurii_Yanchuk\.m2\repository\com\google\code\findbugs\jsr305\3.0.2\jsr305-3.0.2.jar;C:\Users\Yurii_Yanchuk\.m2\repository\org\checkerframework\checker-qual\3.12.0\checker-qual-3.12.0.jar;C:\Users\Yurii_Yanchuk\.m2\repository\com\google\errorprone\error_prone_annotations\2.11.0\error_prone_annotations-2.11.0.jar;C:\Users\Yurii_Yanchuk\.m2\repository\com\google\j2objc\j2objc-annotations\1.3\j2objc-annotations-1.3.jar;C:\Users\Yurii_Yanchuk\.m2\repository\org\openjdk\jmh\jmh-core\1.33\jmh-core-1.33.jar;C:\Users\Yurii_Yanchuk\.m2\repository\net\sf\jopt-simple\jopt-simple\4.6\jopt-simple-4.6.jar;C:\Users\Yurii_Yanchuk\.m2\repository\org\apache\commons\commons-math3\3.2\commons-math3-3.2.jar;C:\Users\Yurii_Yanchuk\.m2\repository\org\openjdk\jmh\jmh-generator-annprocess\1.33\jmh-generator-annprocess-1.33.jar org.openjdk.jmh.Main "edu.yanchuk.benchmark.MyBenchmark.*"
# JMH version: 1.33
# VM version: JDK 16.0.2, OpenJDK 64-Bit Server VM, 16.0.2+7
# VM invoker: C:\Users\Yurii_Yanchuk\.jdks\corretto-16.0.2\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.1\lib\idea_rt.jar=55562:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.1\bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: edu.yanchuk.benchmark.MyBenchmark.binarySearch

# Run progress: 0.00% complete, ETA 00:16:40
# Fork: 1 of 5
# Warmup Iteration   1: 22113739.804 ops/s
# Warmup Iteration   2: 22053286.514 ops/s
# Warmup Iteration   3: 24701700.726 ops/s
# Warmup Iteration   4: 19268157.437 ops/s
# Warmup Iteration   5: 15860151.045 ops/s
Iteration   1: 16030250.722 ops/s
Iteration   2: 16331214.246 ops/s
Iteration   3: 13753524.314 ops/s
Iteration   4: 12568956.917 ops/s
Iteration   5: 13605668.627 ops/s

# Run progress: 10.00% complete, ETA 00:15:10
# Fork: 2 of 5
# Warmup Iteration   1: 21442367.780 ops/s
# Warmup Iteration   2: 23050551.118 ops/s
# Warmup Iteration   3: 21284592.620 ops/s
# Warmup Iteration   4: 22166352.253 ops/s
# Warmup Iteration   5: 18260331.565 ops/s
Iteration   1: 12306414.261 ops/s
Iteration   2: 11841229.834 ops/s
Iteration   3: 12971575.523 ops/s
Iteration   4: 12865242.142 ops/s
Iteration   5: 12309874.780 ops/s

# Run progress: 20.00% complete, ETA 00:13:28
# Fork: 3 of 5
# Warmup Iteration   1: 11455551.407 ops/s
# Warmup Iteration   2: 12362197.292 ops/s
# Warmup Iteration   3: 12473398.522 ops/s
# Warmup Iteration   4: 14007966.587 ops/s
# Warmup Iteration   5: 19485345.170 ops/s
Iteration   1: 12807280.367 ops/s
Iteration   2: 13557558.272 ops/s
Iteration   3: 13120923.361 ops/s
Iteration   4: 12067266.840 ops/s
Iteration   5: 14132392.380 ops/s

# Run progress: 30.00% complete, ETA 00:11:48
# Fork: 4 of 5
# Warmup Iteration   1: 23007780.982 ops/s
# Warmup Iteration   2: 23926620.069 ops/s
# Warmup Iteration   3: 21498630.340 ops/s
# Warmup Iteration   4: 14075262.445 ops/s
# Warmup Iteration   5: 12717881.964 ops/s
Iteration   1: 12797944.532 ops/s
Iteration   2: 13066688.134 ops/s
Iteration   3: 13545642.531 ops/s
Iteration   4: 13319473.988 ops/s
Iteration   5: 13631924.897 ops/s

# Run progress: 40.00% complete, ETA 00:10:07
# Fork: 5 of 5
# Warmup Iteration   1: 10679559.599 ops/s
# Warmup Iteration   2: 12329683.508 ops/s
# Warmup Iteration   3: 12643201.809 ops/s
# Warmup Iteration   4: 12960125.754 ops/s
# Warmup Iteration   5: 12089255.311 ops/s
Iteration   1: 12866561.642 ops/s
Iteration   2: 12665368.955 ops/s
Iteration   3: 13460430.598 ops/s
Iteration   4: 13279147.425 ops/s
Iteration   5: 12804172.316 ops/s


Result "edu.yanchuk.benchmark.MyBenchmark.binarySearch":
13268269.104 ±(99.9%) 775714.517 ops/s [Average]
(min, avg, max) = (11841229.834, 13268269.104, 16331214.246), stdev = 1035556.687
CI (99.9%): [12492554.587, 14043983.621] (assumes normal distribution)


# JMH version: 1.33
# VM version: JDK 16.0.2, OpenJDK 64-Bit Server VM, 16.0.2+7
# VM invoker: C:\Users\Yurii_Yanchuk\.jdks\corretto-16.0.2\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.1\lib\idea_rt.jar=55562:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.1\bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: edu.yanchuk.benchmark.MyBenchmark.recursiveBinarySearch

# Run progress: 50.00% complete, ETA 00:08:26
# Fork: 1 of 5
# Warmup Iteration   1: 11011853.791 ops/s
# Warmup Iteration   2: 10498352.241 ops/s
# Warmup Iteration   3: 10184955.210 ops/s
# Warmup Iteration   4: 11026445.809 ops/s
# Warmup Iteration   5: 10719113.386 ops/s
Iteration   1: 10509392.192 ops/s
Iteration   2: 11728609.268 ops/s
Iteration   3: 17207751.034 ops/s
Iteration   4: 18133144.439 ops/s
Iteration   5: 19080729.024 ops/s

# Run progress: 60.00% complete, ETA 00:06:44
# Fork: 2 of 5
# Warmup Iteration   1: 17709370.061 ops/s
# Warmup Iteration   2: 18918616.619 ops/s
# Warmup Iteration   3: 18225736.133 ops/s
# Warmup Iteration   4: 20400942.305 ops/s
# Warmup Iteration   5: 17663240.025 ops/s
Iteration   1: 19099339.037 ops/s
Iteration   2: 16943166.680 ops/s
Iteration   3: 11544310.391 ops/s
Iteration   4: 10777320.161 ops/s
Iteration   5: 11233597.132 ops/s

# Run progress: 70.00% complete, ETA 00:05:03
# Fork: 3 of 5
# Warmup Iteration   1: 10531765.849 ops/s
# Warmup Iteration   2: 11166684.574 ops/s
# Warmup Iteration   3: 12165876.235 ops/s
# Warmup Iteration   4: 11955277.561 ops/s
# Warmup Iteration   5: 10851155.944 ops/s
Iteration   1: 10598712.280 ops/s
Iteration   2: 10241661.002 ops/s
Iteration   3: 9935999.260 ops/s
Iteration   4: 14502722.000 ops/s
Iteration   5: 11735525.095 ops/s

# Run progress: 80.00% complete, ETA 00:03:22
# Fork: 4 of 5
# Warmup Iteration   1: 11266368.590 ops/s
# Warmup Iteration   2: 10064169.099 ops/s
# Warmup Iteration   3: 10794243.970 ops/s
# Warmup Iteration   4: 11238775.050 ops/s
# Warmup Iteration   5: 9828492.090 ops/s
Iteration   1: 10406271.306 ops/s
Iteration   2: 10908753.885 ops/s
Iteration   3: 9771525.195 ops/s
Iteration   4: 9907118.581 ops/s
Iteration   5: 9636250.885 ops/s

# Run progress: 90.00% complete, ETA 00:01:41
# Fork: 5 of 5
# Warmup Iteration   1: 9997575.681 ops/s
# Warmup Iteration   2: 9573197.399 ops/s
# Warmup Iteration   3: 9917554.660 ops/s
# Warmup Iteration   4: 10244097.855 ops/s
# Warmup Iteration   5: 10014637.465 ops/s
Iteration   1: 11759637.624 ops/s
Iteration   2: 11171210.306 ops/s
Iteration   3: 15618372.679 ops/s
Iteration   4: 20628587.833 ops/s
Iteration   5: 20061581.164 ops/s


Result "edu.yanchuk.benchmark.MyBenchmark.recursiveBinarySearch":
13325651.538 ±(99.9%) 2810930.972 ops/s [Average]
(min, avg, max) = (9636250.885, 13325651.538, 20628587.833), stdev = 3752512.426
CI (99.9%): [10514720.567, 16136582.510] (assumes normal distribution)


# Run complete. Total time: 00:16:52

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                           Mode  Cnt         Score         Error  Units
MyBenchmark.binarySearch           thrpt   25  13268269.104 ±  775714.517  ops/s
MyBenchmark.recursiveBinarySearch  thrpt   25  13325651.538 ± 2810930.972  ops/s

Process finished with exit code 0
