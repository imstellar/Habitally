# Android app overview
Over this GitHub page, I will document my process in creating a habit tracking app using Kotlin and Composables via Android Studio, this README file will contain any relevant documentation that occurs doing the process along with the justifications and explanations required by the assignment's criteria. You can also view any changes made via the commit history which can be found here, [https://github.com/imstellar/Habitally/commits/master/](https://github.com/imstellar/Habitally/commits/master/)

This file is split into parts based on the Assignment's specifications.

This project is utilising Kotlin and Jetpack Compose as its framework via Android Studio which is updated to the latest version throughout development.

## Assignment brief
Below is the assignment documentation that the app will be based from; 

## Scenario
You have been contacted by a local wellness spa and gym. They know you have completed a lot of research on mobile applications previously and have seen your web article. They want you to create a bespoke habit tracking application. Their only key requirements are the following:

- Should be able to track the amount of water someone has drunk in a day (Such as counting glasses of water drunk or litres etc)
- Should be able to track the number of workouts
- Should have a timer that can be used during workouts. 

Please note you do not have to save this information - The app just needs to have the functionality to display / run the above.

They are hoping to see your creativity and ideas with what other things you can add to your mobile application. 

## Task 1
You will first create a design for the application including user interface designs , use-case diagrams , some pseudo code etc. There should also be a creative aspect here with consideration of colour schemes and mentioning of other possible functionality you will or could add to the app additional to the wellness spa’s requirements.

Attempted criteria for this task;

- P3: Produce designs for a mobile app to meet identified requirements.
- P4: Review the mobile app designs with others to identify and inform refinements.
- M2: Justify how decisions made during the design process ensure the design for the app will meet identified requirements.

## Task 2
You are now to create the program. It will begin as a prototype so the looks do not have to exactly meet the plan but it is expected that the key functionality it presents. Therefore your mobile app should be able to do the following:
- Keep track of the amount of water someone has had in a day (User input)
- Be able to track the number of workouts in whichever way you feel would work
- Have some sort of timer that can be used to time workouts
- Has multiple screens OR One other creative function that would be suitable for a wellness gym / spa ( This is where you can show your creativity here)

Attempted criteria for this task;

- P5: Produce a mobile app that meets the design criteria.
- P6: Test a mobile app for functionality, usability, stability and performance.
- P7: Review the extent to which the mobile app meets the identified requirements.
- M3: Optimise a mobile app that meets the design criteria.

## Planning process
Here, lies the documentation for the Task 1 and its criteria, reading this section should fulfill the attempted criteria for that task respectively.

### Font
As a personal rule, I like to use the Montserrat Font Family when developing anything as I believe the font looks really good to look at and maintains accessibility. This font will be used only in the Regular, Medium and Bold styles in the application to preserve a well organised structure. This type of system is well known to ensure layouts in most interpretations feel organised, clear and concise without confusing the user with excess font styling changes.

### Colours
For colours, I have used a Figma plugin named "Material Theme Builder", with it I have generated Primary, Secondary and Tertiary colours devices running the app will generate the rest of the colours based on the device's theme settings. The colours are dynamically picked based on dark or light theme setting on the user's device and are as follows;

#### Dark Theme (80);
- Primary, `#FFB68D`
- Secondary, `#EABDA6`
- Tertiary, `#CDC989`

### Light Theme (40);
- Primary, `#9B4600`
- Secondary, `#795744`
- Tertiary, `#63602B`

### Images
While I have created some background images, I will attempt to utilise the colours of the material theme ruleset, the reasoning for this being that I want the app to follow most used material theme layouts present in modern android apps to keep it familiar. If any colours are used they will available to view inside the [drawable folder](/app/src/main/res/drawable/).

### Application interaction flow
Here, I would like to create a sort of use case diagram in my own way. To better fit the requirements of my application I will be using the "User" as the starting point which will then allow me to consider the actions that "User" will take to do a specific task within the app, eg. Changing a target, with that we can then display what the app needs to do after this interaction is triggered ag. Saving data.

This will be done using [https://draw.io](https://draw.io) and the result can be found [here](/Use-Cases.png).

### Mockup
For a well thought out project you always need to create designs, layouts and mockups that depict what the end result of the product should be. In this case I will use Axure RP 11 to create a design that features the previous considerations including the Use-Cases, Font, Colours and Images to create a mockup that can be used when creating the app, as this is my first time creating a fully fledged app expect major differences in the app's look.

My thought process when creating the mockup is to split the screen into different parts such as the app top bar, Water tracker, Workout tracker and Workout timer these parts can be split into different "Composable" elements in code making the project more modular and provide better stability. Working in this manner also provides the ability to better fit the client's requiremenets in the sense that it ensures each part of their criteria is met within the app and can be modified as needed without major code changes.

When it comes to development, I will utilise the mockup as a framework and try to reference as much of it inside the app while also making sure the app is utilising Material Theme's best practices, this may cause major deviations but it should be expected.

This mockup can be found in the github files as an Axure RP 11 project, [here](/app_mockup.rp) and as a PNG file, [here](TODO).

### Pseudocode
For pseudocode, I will only cover the functionality of the program, in parts, such as adding water to the tracker or removing it. As Kotlin Composables are extremely complex, these will not be included as they are there mainly for the layout of the program itself. When making this code I will split it up into functions that make up each part of the functionality, there will be no main loop or such as it's highly irrelevant in this scenario due to the fact that the user's actions will trigger events rather than a fixed loop.

The Pseudocode can be found as a text file [here](/Pseudocode.txt).

## Developing process

### Layout
Now for the beginning of development, we will first create the layout using Jetpack Compose, this will also feature the Material Theme and it's typography, colours and elements. The app will contain well selected colours for each element but differ from the mock-up's design, I will however try to preserve as much of the mockup's text as possible because that will be needed.

As noted before, the app will feature a modular approach as each section will be separated into their own functions, this can be viewed in the main kotlin file [here](/app/src/main/java/com/assignment/habitally/MainActivity.kt).

## Testing process

## Conclusion