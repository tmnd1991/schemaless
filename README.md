# schemaless
The core foundation for writing type safe, strongly structured data transformations taking advantage of the state of the art tools regardless of the execution enviroment.

## History
In 2010 I was at my last year of Computer Science Technical School and I thought SQL was bad. I was a "master" Pascal and C programmer in my class and I thought that a language that did not tell how to do stuff but rather what obtain was stupid.
### Only stupid people don't change their minds
Oh boy, I was so wrong... Later (2014) in my scholastic "career" I kept thinking that way, until Scala has come to me. It was during a Language and Computational Model class: that "strange" blend of functional/declarative and imperative programming fascinated me so much.
I started then, developing all the projects I could using Scala. First an Apache Storm based project. Then my thesis using Apache Spark and there the circle was (kind of) going to close. Being able to code with Scala collections and understanding basic principles of distributed computing (thanks to that Storm Project) made me realize that those abstractions were the most powerful thing I had came across in my (almost non-existent) programmer career. At that time Spark was mainly RDDs, Spark SQL was just born (Shark for whoever remembers), but the concept that expressing what you want and not how you want it done, started to gain momentum in my mind.

### And then the Dataframe came
It was when project Tungsten has been announced by Databricks that I realized how much SQL, and declarative programming in general, was powerful. Being able to do "meta-programming" and planning stuff based on some rules and a *schema* is pure elegance. 

Therefore I realized what I did not like about SQL: 
1. It is not easy (or impossible) to write generic SQL code
2. It is not easy to test SQL code
3. It is not easy to validate SQL code

And what I did like:
1. _Planning_ enables optimization far beyond the one that can be done at compile time
