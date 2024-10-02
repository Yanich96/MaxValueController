# MaxValueController
The controller takes as input the path to the  XLSX file and the order of the maximum number from this file.
The file contains only unsorted integers, their number must fit in memory.
The controller reads the file, sorts the numbers from largest to smallest and returns the number specified in order.


The controller does not yet handle exceptions.
For example, if you pass a non-existent address or an invalid file, the program will crash.

If you pass a value less than or equal to zero, or if the value is greater than the array size,
the program will return an empty string.


Running the program:
 - mvn clean install
 - java -jar target/MaxValueController-1.0-SNAPSHOT.jar
