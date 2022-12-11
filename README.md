# My eSale (BETA)

I was once approached by an auto parts business owner, who told me that he needed a program that could allow him to enter his products for sale and then have the software create a page with all of the items on display so that he could share it to customers. I decided to use Java 8 for the job and the result was a Maven project, which was originally in Spanish and tailored for that particular business, but afterwards I translated everything to English and reworked the application so that it could be used for any kind of business and be uploaded here.
 
## Preview Images

![alt text](https://i.imgur.com/01IfgIU.png)
![alt text](https://i.imgur.com/sLeGxLP.png)

## IDE, Development Kit and Maven Plugins/Dependencies used

- Apache NetBeans IDE 15
- Java SE Development Kit 8u202
- Apache Maven JAR 2.4 (to build JAR from the compiled project)
- Apache Maven Shade 3.2.1 (to package both the compiled code and required files into a single JAR)
- Apache Maven Shared Utils 3.2.1 (to import FileUtils class into the project)
- FindBugs JSR305 3.0.2
- Plexus :: Default Container 2.1.1

## Known Issues

- Currently there's no option to select another directory to save the page other than the default one.
- Lack of code commentary.
- There's no limit to the types of characters you can enter on any text field.
- There's no prompt to overwrite previously generated page files, which might lead to accidental deleting.

## Upcoming Features

- More options for page design customization.
- Possibility to load and save inputted data.
- Support for localizations.
- Tool tips and user documentation.
- Fixing of known issues.
