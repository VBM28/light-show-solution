# Light-shows solution #

## Business Logic ##
- The input will be processed in the _FileReaderService_ as a **_list of Instruction objects_**.
- Each line will be processed as a _on, off or toggle command_.
- Possible exceptions from reading the file(both exceptions are handled as printing the exception message to the console and continuing reading the file):
  - `Instruction cannot be processed` exception, caused by a different from expected input on one of the instruction lines. The line at fault will be specified in the exception message.
  - `Error parsing the parameter from String to Integer` exception, caused by a formatting error of one of the numbers. The element at fault will be specified in the exception message.
- After the instruction list is returned, based on the version specified, the logic is as follows:
  - **_For Part 1(version=1)_**:
    - For each instruction, each element of the [x] [y] coordinates will be tracked in the hashmap of <String,Boolean>, the key structure being "x-y" and updated based on the instruction specified(on,off, toggle).
    - Once all the instructions are processed, the hashmap if filtered to find all the entries with the value **true** and return the count of them.
  - **_For Part 2(version=2)_**
    - Similar to the part 1, the elements are updated in a hashmap of <String,Integer> with the same structure for the key, and the value is once again updated based on the instruction specified.
    - Once the instructions are processed, all the elements with value > 0 are filtered and the sum of them is returned.
## Setup ##
- The code requires 2 environment variables:
    - `filePath` in which the path to the txt input file needs to be specified.
    - `version` which can have the value **1** or **2** (to specify which of the 2 implementations will be used for processing the instructions). In case the variable does not have one of the 2 specified values, the method call will return 0.

