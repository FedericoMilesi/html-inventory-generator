# My eSale (BETA)

In June of this year, I was hired by a car parts shop owner to write some software. He needed a desktop program that would allow him to enter car replacements on sale and then have the program automatically create a good looking page with all of the items on display, as well as the shop address, logo and contact info. 

I decided to use Java for the task and the end result was this Netbeans project.
 
## Screenshots

![alt text](https://i.imgur.com/7N5TdFWl.png)
![alt text](https://i.imgur.com/sLeGxLP.png)

## Tools and complements used

- Apache NetBeans IDE 15
- Apache Maven JAR 2.4 (to build JAR from the compiled project)
- Apache Maven Shade 3.2.1 (to package both the compiled code and required files into a single JAR)
- Apache Maven Shared Utils 3.2.1 (to import FileUtils class into the project)
- FindBugs JSR305 3.0.2
- Plexus :: Default Container 2.1.1

## Known Issues

- Currently there's no option to select another directory to save the page other than the default one.
- If you want to have everything in a single printable page, it's recommended that you don't enter more than six items for sale if you're also adding contact info, or else everything won't fit in just one page. 
- Lack of code commentary.
- There's no limit to the types of characters you can enter on any text field.
- There's no prompt to overwrite previously generated page files, which might lead to accidental deleting.

## Upcoming Features

- More options for page design customization.
- Possibility to load and save inputted data.
- Support for localizations.
- Tool tips and user documentation.
- Fixing of known issues.
