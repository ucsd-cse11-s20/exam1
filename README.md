# Exam 1

This page details a **take-home exam** that you will complete over the next few
days.

You will complete the programming task below and submit the corresponding Java
file to the `exam1` Gradescope assignment.

You will also submit a **video screencast** of yourself presenting a portion of
it to this Google Form [fill].

## Tasks

Download the code for the `Query` example from the reading:

https://cseweb.ucsd.edu/classes/sp17/cse11-a/lecture11.html

### Task 1

- Add a new field to `ExamplesSearch` called `task1b` that is a query that
returns `true` on `matches` for images that have the extension `"jpg"`.

- Add a new field to `ExamplesSearch` called `task1a` that is a query that
returns `true` on `matches` for images that have the keyword `"ucsd"` and do
not have the keyword `"ucsf"`. Provide examples of matching on:
  1. [Vid1-SDNotSF] An image that has the keyword `"ucsd"` and not `"ucsf"`
  2. [Vid1-SDSF] An image that has the keyword `"ucsd"` and has the keyword `"ucsf"`
  3. [Vid1-NoSDSF] An image that does not have either `"ucsd"` or `"ucsf"` as a keyword

### Task 2

Add a new type of query called `NoKeywords` that represents a query
for images that have no keywords. Assume that images with no keywords have
the empty string `""` as their `keywords` field.

Demonstrate it on at least two image inputs.

### Task 3

Add a new type of query called `EitherQuery` that represents a combination of
two queries where one, but not the other, matches.

Create an `EitherQuery` where both of the queries being combined are
`AndQuery` objects with different matching behavior. Demonstrate using this
query twice, once returning `true` and once returning `false`.

### Task 4 – Video

You will record a short video of no more than 5 minutes. Include:

- Your face and your student ID for a few seconds at the beginning. You don't
  have to be on camera the whole time, though it's fine if you are. Just a
  brief confirmation that it's you creating the video/doing the work attached
  to the work itself is what we want.
- A capture of your screen running your program. Demonstrate and describe in
  a clear and audible voice the following tasks described below.

  1. Choose one of the examples labeled above for Vid1 based on your student
  ID. If your student ID:

  - Ends in 0-3, choose [SDNotSF]
  - Ends in 4-6, choose [SDSF]
  - Ends in 7-9, choose [NoSDSF]

  Run the program and show the output corresponding to the method call for
  this example. Then, starting from the line in your code with the test,
  indicate each line of code that runs in your program while evaluating that
  method call. You can scroll to and click the lines to highlight them, or
  otherwise indicate each one. You should indicate them in the order that
  **Java will evaluate them**.

  2. For this task, repeat the process of running the program, showing the
  output, and indicating which lines run and in which order. This time, do it
  for the `EitherQuery` you created in Task 3.



