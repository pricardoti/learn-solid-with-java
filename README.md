# O que é S.O.L.I.D ?

![Solid Design ](https://img.shields.io/badge/Solid%20Design-Principles%20in%20Java-red?longCache=true&style=for-the-badge)

SOLID é um acrônimo criado por Michael Feathers, após observar que cinco princípios da orientação a objetos e design de código (uma coleção de práticas importantes de programação) — Criados por Robert C. Martin (a.k.a. Uncle Bob) e abordados no artigo [The Principles of OOD](http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod).

Knowing SOLID principles is a must have skillset for any software developer.

This is Swiss Army Knife. As you know,a swiss army knife is a combination of a number of useful tools, each one with a distinct purpose. You can have anything from a can opener to a pair of mini scissors or even a screw driver inside a Swiss Army knife.

Although a Swiss Army knife is a versatile tool and much sought after and appreciated, when you come to software, the rules change. If you think of the Swiss Army Knife as a software component, it violates the

---

These are the words that Robert "Uncle Bob" Martin uses in his book, to define single responsibility principle

So whats this new phrase 'reason to change'?
>In the words of the Greek Philosopher - Heraclitus . "The only thing that is constant is change".

Software is never dormant it always keeps changing.

the SOLID principles are not some fancy good-to-have things for your software. These are important design principles which can translate to considerable software maintenance costs in the long run.

### S.O.L.I.D: Os 5 princípios da P.O.O.

S — Single Responsiblity Principle (Princípio da responsabilidade única) <br />
O — Open-Closed Principle (Princípio Aberto-Fechado) <br />
L — Liskov Substitution Principle (Princípio da substituição de Liskov) <br />
I — Interface Segregation Principle (Princípio da Segregação da Interface) <br />
D — Dependency Inversion Principle (Princípio da inversão da dependência) <br />

These are simple but cardinal design principles, that will enable you to create elegant and robust software.

- Estes são princípios de design simples, mas fundamentais, que permitirão criar software elegante e robusto.

---

#### SRP - Single Responsiblity Principle 

> "Every software component should have one and only one responsibility."

*Component canbe a class, a method, or a module.*

***So what is this principle?*** 

The Single Responsibility Principle says that each method / class should be responsible for one specific activity. Inserting everything into one method does not meet the basic assumptions of objectivity, but also makes it difficult to read, repair or expand programs.

We work on two concepts - ***Cohesion and Coupling***.

Single Responsibility Principle always advocates higher cohesion and always receommends loose coupling. So always aim for Higher Cohesion and Loose Coupling, hope the two concepts are clear.

###### Cohesion

Cohesion is the degree to wich the various parts of a software component are related.
Higher Cohesion helps attain better adherence to the Single Responsability Principle.

Before:
```
public class Square {

    private boolean highResolutionMonitor = true;
    private int side = 5;

    public int calculateArea() {
        return side * side; // side² - side ^ 2;
    }

    public int calculatePerimeter() {
        return side * 4;
    }

    public void draw() {
        if (highResolutionMonitor) {
            // Render a high resolution image of a square
        } else {
            // Render a high normal image of a square
        }
    }

    public void rotate() {
        // Rotate the image of the square clockwise to
        // the required degree and re-render
    }
}
```

We could say that the contents of the unsegregated waste bin have a low cohesion, and the contents of each of the segregated waste bins have a high cohesion.

Lets apply the same principle here. What do you make of the methods inside the ```Square``` class?

The methods calculateArea and calculatePerimeter are closely related, in that they deal with the measurements of a square. So there is a high level of cohesion between these two methods.
The ```draw()``` method and the ```rotate()``` method deal with rendering the image of the square in a certain way on the display.

So there is a high level of cohesion between these two methods as well.

But if you take all of the methods as a whole, the level of cohesion is low.
For instance , the ```calculatePerimeter()``` method is not closely related to the ```draw()``` method...

After:

```

// Responsability: Measurements of squares

public class Square {
    
    int side = 5;

    public int calculateArea() {
        return side * side; // side² - side ^ 2;
    }

    public int calculatePerimeter() {
        return side * 4;
    }

}

// Responsability: Rendering images of squares

public class SquareUI {
    
    public void draw() {
        if () {
            // Render a high resolution image of a square
        } else {
            // Render a high normal image of a square
        }
    }

    public void rotate() {
        // Rotate the image of the square clockwise to
        // the required degree and re-render
    }
}
```

I'll name the class as ```SquareUI```. By doing this, even though I have split the methods into two classes, I have increased the level of cohesion in each of the classes. All the two methods inside the Square class are now closely related, as both of them deal with the measurements of the square.
All the two methods inside the ```SquareUI``` class are now closely related, as both of them deal with the graphic rendering of the square. So one aspect of the Single Responsibility Principle is that, we should always aim for high cohesion within a component, component means class in this case.

###### Coupling

Coupling is defined as the level of inter dependency between various software components.

Before:
```
public class Student {

    private String id;
    private String name;
    private String address;

    public void save() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");

            statement = connection.createStatement();
            statement.execute("INSERT INTO student VALUES (" + this.getId() + ", " + this.getAddress() + ", " + this.getBirth() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // others getter and setters...
}
```


After:
```
// Responsability: Handle core student profile data

public class Student {

    private String id;
    private String address;
    private String name;

    public void save() {
        new StudentRepository().save(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // others getter and setters...
}

// Responsability: Handle Database operations for students

public class StudentRepository {
    public void save(Student student) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDB", "root", "password");

            statement = connection.createStatement();
            statement.execute("INSERT INTO student VALUES (" + student.getId() + ", '" + student.getName() + "', '" + student.getAddress() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

- [x] Aim for High Cohesion.
- [x] Aim for Low Coupling.

We also saw how following the single responsiblity principle can lead to considerable savings in software maintenance costs.

---

#### OCP - Open/close principle

>"Software components should be closed for modification, but open for extension" 

The OCP principle says that the classes we create are open to extensions and closed to modifications. At the beginning of OCP, we are able to repeatedly use our classes for various tasks, which promotes reuse of the code, but also facilitates understanding.

Let's look at this principle in a practical way, for example:

Let's imagine a code snippet shows how premium discounts are calculated.

We have an InsurancePremiumDiscountCalculator class that has a generatePremiumDiscountPercent.

This method takes a HealthInsuranceCustomerProfile object as an argument.

Let's see what this class is: So HealthInsuranceCustomerProfile

has an isLoyalCustomer () method that returns a true value if the current customer is a loyal customer. If no,

it simply returns false. Therefore, this HealthInsuranceCustomerProfile object is the entry for the calculPremiumDiscountPercent method.

The calculation method calls the isLoyalCustomer () method on the HealthInsuranceCustomerProfile entry object and

makes more discount calculations based on whether the customer is loyal or not.

So far, so good.

Tomorrow, a state-owned company acquires another insurance company that operates mainly with Vechicle Insurance.

They change their slogan accordingly. For all your health and vehicle insurance needs.

So now we also have to support discounts on vehicle insurance.

One State decided that the discount calculation will be the same,

that is, it will always be based on loyalty, regardless of your health, vehicle or any other type of insurance.

Okay, so to deal with that, we added a new class to our design. VehicleInsuranceCustomerProfile.

This is exactly like the HealthInsuranceCustomerProfile class. It has an isLoyal () method that returns a Boolean value.

So, are we done? No, this is where the problems begin.

Now we have to modify the Calculator class, because the calculation method currently receives a HealthInsuranceCustomerProfile object.

We want it to also carry a VehicleInsuranceCustomerProfile object.

The only way out is to add a new overloaded method that receives a VehicleInsuranceCustomerProfile object.

This is just the beginning. What if we also want to take care of home insurance?

We need to add code again to this Calculator class. So, why isn't this good?

As to add a new feature, we need to tap on the existing code,

which goes against our Open Closed Principle. The existing code must be closed for modification.

Let's refactor our design and see if we can solve this problem.

We will revert our Calculator class again. We will create a new interface called CustomerProfile.

The interface defines only one method: isLoyalCustomer

We will make sure that both client profile classes implement this common interface.

Okay, now in the Calculator class, we will change the argument of the method.

Instead of a HealthInsuranceCustomerProfile, we will make you a CustomerProfile.

We are done.

In light of that, it may seem that we had to work harder this time.

But the beauty of this design is in the way it deals with future extensions. Suppose One State also enters the home insurance business.

They change their slogan again.

Therefore, we will need to create a HomeInsuranceCustomerProfile object.

We make you implement the common CustomerProfile interface.

Nothing, we DO NOT need to touch the Calculator class.

All we did was: add a new class implementing an existing interface.

Neither the calculator class, nor the interface, nor any of the existing classes had to be modified.

See how it makes the process of adding extensions much cleaner.

in a more elegant way. So, that was an example for the Open Closed Principle.