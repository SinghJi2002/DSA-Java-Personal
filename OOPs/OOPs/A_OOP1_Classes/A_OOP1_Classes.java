package OOPs.A_OOP1_Classes;
/*Clases are structures in java that allow to define a datatype the way we want. A more formal defination would be that classes are templates.

For example lets say we want to create a database that stores name, roll and marks of student. Now in a general case we would need to create 2 integer array and a string array to store the three entities and in that case they will not be together but in 3 different structures, something that we dont want. Here clases come in. In place of using traditional data sturctures like array, we can create our new data structure that can store name, roll and marks of the student together. We do this using classes, below see us defining student class.*/

public class A_OOP1_Classes{
    //Here we are creating new datastructure students which will store student data.
    class students{
        //Here we will define the properties of student. These are formally termed as instance variables. All the variables inside the class are termed inside the class.
        String name;
        int roll;
        float marks;
        //Here we have completed creating a new datastructure student.

        //Lets now make a constructor. A constructor defines what occurs when an object of a class is created. Look how do we actually create a constructor.

        //students(){};

        //Above is a constructor. Yes, the first rule of a creating a constructor is that its name should be the same as the name of the class. The second rule is that it does not has a return type. The constructor which we see above is constructor that takes no argument and doesn't modify any of the instance variables. Lets see another constructor.

        public students(String name, int roll, float marks){
            this.name=name;
            this.roll=roll;
            this.marks=marks;
        }

        //Above we see a constructor that takes all the instance variables as its arguments. Then redefines them for a particular object. Now a important thing that you might notice is the "this" keyword. In code in the main file, when we wanted to change the name of the reference ashutosh, the code we wrote was, ashutosh.name. The "this" keyword is acting as substitute of "ashutosh". This is used because there is not only a ashutosh object, but multiple objects and it acts as a reference of all those objects that call upon this constructor.

        //Lets see another constructor.

        public students(int roll, float marks){
            this.roll=roll;
            this.marks=marks;
        }

        //Above we see mulitple construction. Essentially constructors are functions with the same name but no return type. There are 3 similarly name functions(constructors) with the only difference being the parameters they take. The act of create multiple constructors with same name but different parameters is termed as constructor overloading.

        //Lets see a few instances where we are calling a constructor from constructor. Note that for this process we use "this" keyword.
        public students(){};

        /*
        students(){
            this("Dikshant",157,100);
            //In action it will call the first constructor. In process this code looks something like this, student("Dikshant",157,100).
        }
        */
    }


    public static void main(String[] args) {
        /* When we talk about classes we need to also talk about objects. Objects are nothing but instance of clases. Now objects have 3 characteristics, state, identity and behavior.
        
        The state of an object is a value from its data type. 
        
        The identity of an object distinguishes one object from another.It is useful to think of an object’s identity as the place where its value is stored in memory. Objects are stored in heap and the variables pointing to them are stored in stack.
        
        The behavior of an object is the effect of data-type operations. All the methods one includes in the class of this object can be refered to define object's behavior.

        Now next is how do we create a object. See the code below.
        */

        students ash=new students();
        /*Here we have just initialised the first student object refered as ashutosh. This reference will be stored in stack and pointing to null in heap since it has not been initialised yet. */

        
        /*The 'new' keyword dynamically allocates memory for an object(creates its instance in heap) & returns a reference to it(which is stored in variable in stack pointing to it in heap). This reference is, more or less, the address in memory of the object allocated by new. Thus, in Java, all class objects must be dynamically allocated.
        The dynamically alloted part means that the object is being created on the heap at run-time, while the reference variable gets intantiated at the compilation time itself.

        One aspect of dynamic memory allocation is show in the code below.
        */

        students barun=new students("Barun",21,34);
        students saha=barun;

        //In the code above there will be a object created and reference to it will be stored with barun. When saha is equation to barun we see that in place of creating of copy of object, saha points to the same object. Hence changes made in either saha or barun will affect the same object.

        /*Since we are dicussing OOPs lets also discuss difference between objects and primitives.
        Datastructures such as the students(which we created here), string, array and etc are termed as objects and thier default value is null. These are implemented in heap memory and hence require new keyword for dynamic allocation of memory to objects.

        On the other hand, integers, float, character etc are primitives. Thier default value is not null. For integer its 0, for float its 0.0 and so on. Primitives are implemented in stack and hence do not require new keyword. Primitives are follow static memory allocation. 
        */

        
        ash.marks=100;
        ash.name="Ashutosh Kumar Singh";
        ash.roll=974;
        

        /*Above we see we are initializing the instance variables of reference ashutosh. Until now all these variables were set to thier default values(depending on whether they are primitive or object). */

        /*In context of the three lines of code you see above, its kind of irritating and not so organised to declare the values of instance variables in that way. Here is where constructors come in. Please refer to class code of constructor above. */

        // We discussed two constructors above. Lets use both of them here.
        students divyansh=new students();
        students ashish=new students("Betichod",888,8.5f);
        //Give them a run and see the difference

        //Though if do want to  access the data stored in each object we need to use the tradistional method.
        System.out.println(divyansh.roll);
        System.out.println(ashish.name);


        //Now lets talk about wrapper classes. We have discussed about primitives and objects. What if we want the primitives to be treated as objects? That is where the wrapper classes come in. For int primitive, we have Integer wrapper class for objectification. Similarly Float for float primitive, Character for char primitive and so on. See the examples.
        Integer a=new Integer(15);
        Long c=new Long(12);
        /*Lets talk a bit more about java itself. In java when we make function calls, the system followed is pass by value. This happens until we start passing objects which automatically makes it pass by reference. Given this, the availability of wrapper classes to make primitives behave as objects helps as it allow pass by reference in thier cases too. So when changes is made in them in the function, they reflect in main too. Though one thing to see here is that, this may be not the case for wrapper classes. This is because the access modifiers for most of these classes is set to final. Now what is final?

        Now final is an kind of access modifier. It affects the code in the following ways:
        1)If a primitives access is set to final, then, first rule to follow is to always allocate the variable some value at the time of allocation or else error will be generated. That is, "final int a;" is wrong meanwhile, "final int a=10" is write. Now what final keyword actually does is that it makes the value primitive datatypes un-editable. That is, if I write a code,
        "final int a=10;
        a=15;"
        It will generate error since a is set to 10 and cannot be edited.
        
        2)If a object's access is set to final, then in that case, its not neccessary to initialize value at the time of creation. It can be done later. But once intialisation is made, then it cannot be edited. What final does in case of objects is that it fixes thier pointer to one object in heap, hence when we re-instantiate it, it produces error. See example below to understand,
        "final student ashutosh;(No error)
        ashutosh=new student("Ashutosh",157,100);(No error)
        ashutosh.name="singh";(No error)
        ashutosh=new student();(Error)"
        This implies that when final is set on object, we cannot change the object to which a variable references to.
        */
        
    }
}
/*Objects are stored in heap and the variables pointing to them are stored in stack. 
After thats done, next is creating object. The general code of creating a new object is,
<DataStructure><Variable Name>=new <DataStructure>(Instantiation)

After we create a object of particular class, next question is how do we access values of the object
*/