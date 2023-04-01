Homework 

First to describe the generic command execute() I chose to use an abstract class so it can be extended by all the other classes that will override the method;
- For the ReportCommand class I used FreeMarker to generate the text output of the html page. In the resources folder I created another one called templates in order to save the report.ftl file which contains my template and to handle the exceptions I used printStackTrace because I found it useful to solve the errors;
- In order to keep track of connections between my documents and their characteristic, be it location, id or name, I created informations HashMap to do so;
- The html file is opened using Desktop class;
![image](https://user-images.githubusercontent.com/100404656/229293993-06104629-ac9e-4521-a4c3-c207cf030bdf.png)
