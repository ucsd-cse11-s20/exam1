# Exam 1

This page details a **take-home exam** that you will complete over the next
few days. You can't communicate with anyone about the content of the
assignment until you receive your grade. The course staff will not give
debugging advice or answer questions about the problems. If you have
technical trouble creating a screencast (detailed below) feel free to reach
out for assistance.

You **can** make use of any course notes, online resources, Java tools, and
so on to complete the exam.

You will complete the programming task below and submit `ExamplesSearch.java`
to the `exam1` Gradescope assignment.

You will also submit a **video screencast** of yourself presenting a portion of
it to this [Google Form](https://docs.google.com/forms/d/e/1FAIpQLSco7eqdZ_GaZCG9QqQ2wpDbsF39CL-6LNuhu-jzUtjd8hb6vQ/viewform).

Submission checklist (see long descriptions below for full details):

- `[ ]` Fields `task1a` and `task1b` in `ExamplesSearch` class
- `[ ]` Three examples of testing `task1b` in `ExamplesSearch` class
- `[ ]` `AreaLessThan` class
- `[ ]` Two constructed `AreaLessThan` objects
- `[ ]` Four total tests for `AreaLessThan` (two for each object)
- `[ ]` `EitherQuery` class
- `[ ]` Constructed `EitherQuery` object with one `AndQuery` and one other query
- `[ ]` Two tests using this constructed `EitherQuery` object
- `[ ]` Screencast
  - Show ID
  - Trace evaluation of `task1b` test
  - Trace evaluation of `EitherQuery` test

Your submission will be graded **after** the deadline. The Gradescope upload
will just check to make sure that there aren't any errors reported by Java
when we try to run your programs, not whether tests succeeded or failed. You
should test thoroughly yourself to make sure your program works as expected.

## Tasks

Download this starter code:

[https://github.com/ucsd-cse11-s20/exam1](https://github.com/ucsd-cse11-s20/exam1)

(This is very lightly adapted from [this reading](https://cseweb.ucsd.edu/classes/sp17/cse11-a/lecture11.html))

You should **not** change any of the existing methods or classes except for
adding to `ExamplesSearch`. Don't change `ImageQuery` or the other query
classes, just add new ones as described below.

### Task 1

- Add a new **field** to the `ExamplesSearch` class called `task1a` of type
`ImageQuery`. Its value should be a query that returns `true` on `matches`
for images that have the extension `"jpg"`.

- Add a new field to `ExamplesSearch` called `task1b` of type `ImageQuery`.
Its `matches` method should return `true` for images that have the keyword
`"ucsd"` and do **not** have the keyword `"ucsf"` (`false` otherwise).
Construct `ImageData` inputs matching these descriptions, and show how the
query you constructed behaves when `match`ing each of them:
  1. An image that has the keyword `"ucsd"` and not `"ucsf"`
  2. An image that has the keyword `"ucsd"` and has the keyword `"ucsf"`
  3. An image that does not have either `"ucsd"` or `"ucsf"` as a keyword

### Task 2

Add a new type of query called `AreaLessThan` that represents a query that
returns whether the area of an image (its width times its height) is less
than an area provided to the query. It should implement `ImageQuery`.

Test the new class by creating two example `AreaLessThan` queries, and
testing **each** on two inputs: one example that returns `true` and one
that returns `false`. You can write these as fields in `ExamplesSearch` or as
tester methods, your choice, but they must be clearly indicated as the tests
for Task 2.

### Task 3

Add a new type of query called `EitherQuery` that represents a combination of
two queries that returns true if either one matches, but false if both or
neither match. For example, for an `EitherQuery` combining a keyword search
for `"apple"` and a keyword search for `"banana"`:

- It should return `true` when `match`ing an `ImageData` with keywords
`"apple orange"`
- It should return `true` when `match`ing an `ImageData` with keywords
`"fruit banana"`
- It should return `false` when `match`ing an `ImageData` with keywords
`"apple orange banana"`
- It should return `false` when `match`ing an `ImageData` with keywords
`"no fruit here"`

Then, create an `EitherQuery` object. Demonstrate using this query's
`matches` method on two different `ImageData` inputs, once returning `true`
and once returning `false`.

### Task 4 – Video

You will record a short video of no more than 8 minutes. Include:

- Your face and your student ID for a few seconds at the beginning. You don't
  have to be on camera the whole time, though it's fine if you are. Just a
  brief confirmation that it's you creating the video/doing the work attached
  to the work itself is what we want.
- For the _second_ example from `task1b` – “An image that has the keyword
  `"ucsd"` and has the keyword `"ucsf"`”:

  Run the program and show the output corresponding to the method call for
  this example. Then, starting from the line in your code with the the call
  to the `matches` method, indicate each line of code that runs in your
  program while evaluating that method call. You can scroll to and click the
  lines to highlight them, or otherwise indicate each one. You should
  indicate them in the order that
  **Java will evaluate them** (this might be different than the order they
  *appear in the file).

- For this task, repeat the process of running the program, showing the
output, and indicating which lines run and in which order. This time, do it
for one of the calls to the `matches` method of `EitherQuery` you created in
Task 3.

An example of what your video should look like when doing this kind of
explanation is here:

[https://drive.google.com/open?id=1E-TcVXSg9BI4MnWoVU9_BbcRJsu8ZhCf](https://drive.google.com/open?id=1E-TcVXSg9BI4MnWoVU9_BbcRJsu8ZhCf)
