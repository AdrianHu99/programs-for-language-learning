### JavaScript 

##### Variable Scope:   

        Variable will be searched for in its current scope first. If not found, the outer reference will be searched. 
        If not found there, the outer reference's outer reference will be searched and etc., and so on. 
        If not found, the outer reference's outer reference will be searched, and etc., and so on. 
        Now this will keep going until the global scope. If not found in global scope, the variable is going to be undefined. 
##### Object types

        Object type is a collection of name/value pairs.
        
##### Primitive types
        
        Primitive type represents a single, immutable value. 
        Immutable means once it's set, it can't be changed. Values will be read-only.
        
* Null: Null signifies lack of value
* Undefined: Undefined means lack of definition. That actually means variable memory has been allocated but no value has been set yet.  
* Number: Always presented under the hood as double-precision 64-bit floating point
* String: either single or double quotes
* Symbol: 
* JS does not have an integer type

##### Common Language Constructs
* If we use `==`, it will convert types to the same type and then compare;
* If we use `===`, it will strictly compare these two variables, including the types;
* False || null || undefined || "" || 0 || NaN will all be regarded as false;
* True && "hello" && 1 &&　-1 && "false" will be regarded as true;
* There must be something after `return`, like `return {`;


##### Default Values

* sideDish = sideDish || "whatever";


##### Objects

* Example of creating an object

      var company = new Object();
      company.name = "facebook";
      company.ceo = new Object();  //this part is important, as you have to create an object before doing sth below:
      company.ceo.name = "Mark";
      
      console.log([company.name]); //or console.log([company["name"]);
      var xxx = "stock of company";
      company[xxx] = 110;
      
* Better way: object literal

      var facebook = {
        name: "facebook",
        ceo: {
          firstName: "mark",
          favColor: "blue"
        },
        $stock:110
      }; //remember always to add a ";" after "}"
      
##### Functions

* Every function has a toString() method, we can use console.log(function_name.toString()) or console.log(function_name) to show them up.

* Functions can be passed as arguments.  

##### Variables

* Passing variables by value vs. Passing variables by reference

      Given b = a, passing by value means changing copied value in b does not affect the value stored in a and vise versa.
      Passing by reference means changing copied value in b does affect the value stored in a and vise versa.
      
* Primitives are passed by value and objects are passed by reference
        
##### Functions

* To have some functions kind of common inside of a function, we can use prototype. So that we don't need to create that common function every time we create a new function.

* If the function only has one argument in definition, but in use there are two arguments passed in, then don't worry, it's prefectly legal to do that.
